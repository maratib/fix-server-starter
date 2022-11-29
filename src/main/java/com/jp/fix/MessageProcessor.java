package com.jp.fix;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import quickfix.*;
import quickfix.fix50sp2.*;
import quickfix.fix50sp2.Message;
import quickfix.field.*;

@Slf4j
@Component
public class MessageProcessor {

    public MessageProcessor() {
        System.out.println("Message processor initiated ...");
    }

    public void sendSampleMsg() {

        ExecutionReport exe = new ExecutionReport();
        // genOrderID(), genExecID(), new ExecType(ExecType.TRADE), new OrdStatus(
        // OrdStatus.FILLED),
        // Side.SELL, new LeavesQty(0), new CumQty(
        // orderQty.getValue()));;

        exe.set(genOrderID());
        exe.set(genExecID());
        exe.set(new ExecType(ExecType.NEW));
        // exe.set

        // quickfix.fix50.ExecutionReport accept = new quickfix.fix50.ExecutionReport(
        // genOrderID(), genExecID(), new ExecType(ExecType.NEW), new OrdStatus(
        // OrdStatus.NEW),
        // '1', new LeavesQty(0),
        // new CumQty(0));

        // sendMessage(null, null);
    }

    private void sendMessage(SessionID sessionID, Message message) {

        try {

            Session session = Session.lookupSession(sessionID);
            if (session == null) {
                throw new SessionNotFound(sessionID.toString());
            }

            DataDictionaryProvider dataDictionaryProvider = session.getDataDictionaryProvider();
            if (dataDictionaryProvider != null) {
                try {
                    dataDictionaryProvider.getApplicationDataDictionary(
                            getApplVerID(session, message)).validate(message, true);
                } catch (Exception e) {
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

    private ApplVerID getApplVerID(Session session, Message message) {
        String beginString = session.getSessionID().getBeginString();
        if (FixVersions.BEGINSTRING_FIXT11.equals(beginString)) {
            return new ApplVerID(ApplVerID.FIX50);
        } else {
            return MessageUtils.toApplVerID(beginString);
        }
    }

    private int m_orderID = 0;
    private int m_execID = 0;

    private OrderID genOrderID() {
        return new OrderID(Integer.toString(++m_orderID));
    }

    private ExecID genExecID() {
        return new ExecID(Integer.toString(++m_execID));
    }

}
