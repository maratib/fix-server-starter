package com.jp.fix.server;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import quickfix.*;

@Component
@Slf4j
public class ServerApplication implements Application {

    private static String LOGGED_IN = "Y";
    public static SessionID sessionID;

    @Override
    public void onCreate(SessionID sessionID) {
        System.out.println(String.format("onCreate: SessionId={%s}", sessionID));
        ServerApplication.sessionID = sessionID;
    }

    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println(String.format("onLogon: SessionId={%s}", sessionID));
    }

    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println(String.format("onLogout: SessionId={%s}", sessionID));
    }

    @Override
    public void toAdmin(Message msg, SessionID sessionID) {
        // msg.setString(141, LOGGED_IN);
        // System.out.println(String.format("toAdmin: {%s}, {%s}", msg, sessionID));
    }

    @Override
    public void fromAdmin(Message msg, SessionID sessionID)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        // System.out.println(String.format("fromAdmin: {%s}, {%s}", msg, sessionID));
    }

    @Override
    public void toApp(Message msg, SessionID sessionID) throws DoNotSend {
        System.out.println(String.format("toApp: {%s}, {%s}", msg, sessionID));
    }

    @Override
    public void fromApp(Message msg, SessionID sessionID)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println(String.format("fromApp: {%s}, {%s}", msg, sessionID));
    }

}
