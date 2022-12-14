package com.jp.fix;

import org.springframework.stereotype.Component;

import com.jp.fix.server.Messages;
import com.jp.fix.server.ServerApplication;

import lombok.extern.slf4j.Slf4j;
import quickfix.fix50sp2.Message;
import quickfix.*;
import quickfix.field.*;

@Slf4j
@Component
public class MessageProcessor {

    public MessageProcessor() {
        System.out.println("Message processor initiated ...");
    }

    public void sendSampleMsg() {

        // exe.set

        // quickfix.fix50.ExecutionReport accept = new quickfix.fix50.ExecutionReport(
        // genOrderID(), genExecID(), new ExecType(ExecType.NEW), new OrdStatus(
        // OrdStatus.NEW),
        // '1', new LeavesQty(0),
        // new CumQty(0));

        // sendMessage(ServerApplication.sessionID, exe);
        // sendMessage(ServerApplication.sessionID, Messages.getExecMessage());
        sendMessage(ServerApplication.sessionID, Messages.getExecution());
        // sendMessage(ServerApplication.sessionID, Messages.getReport1());
    }

    private void sendMessage(SessionID sessionID, Message message) {

        try {

            Session session = Session.lookupSession(sessionID);

            if (session == null) {
                throw new SessionNotFound(sessionID.toString());
            }

            DataDictionaryProvider dataDictionaryProvider = session.getDataDictionaryProvider();
            if (dataDictionaryProvider != null) {
                System.out.println("Ssssss 3");
                try {

                    dataDictionaryProvider.getApplicationDataDictionary(
                            getApplVerID(session)).validate(message, true);

                    System.out.println("Ssssss 4");

                } catch (Exception e) {

                    // e.printStackTrace();
                    System.out.println(e.getMessage());

                    LogUtil.logThrowable(sessionID, "Outgoing message failed validation: "
                            + e.getMessage(), e);
                    return;
                }
            }

            session.send(message);

        } catch (SessionNotFound e) {
            log.error(e.getMessage(), e);
        }

    }

    private ApplVerID getApplVerID(Session session) {
        String beginString = session.getSessionID().getBeginString();
        if (FixVersions.BEGINSTRING_FIXT11.equals(beginString)) {
            return new ApplVerID(ApplVerID.FIX50SP2);
        } else {
            return MessageUtils.toApplVerID(beginString);
        }
    }

}
