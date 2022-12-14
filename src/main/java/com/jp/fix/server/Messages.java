package com.jp.fix.server;

import java.time.LocalDate;
import java.time.LocalDateTime;

import quickfix.*;
import quickfix.Message.Header;
import quickfix.fix50sp2.*;
import quickfix.fix50sp2.Message;
import quickfix.field.*;

public class Messages {

    private static int m_orderID = 0;
    private static int m_execID = 0;

    private static OrderID genOrderID() {
        return new OrderID(Integer.toString(++m_orderID));
    }

    private static ExecID genExecID() {
        return new ExecID(Integer.toString(++m_execID));
    }

    public static ExecutionReport getReport1() {
        // ExecutionReport executionReport = new ExecutionReport(new
        // OrderID("3-2-805331618T-0-0"),
        // new ExecID("3-2-805331618T-0-0"), new ExecType(ExecType.TRADE),
        // new OrdStatus(OrdStatus.FILLED), new Side(Side.BUY), new LeavesQty(0), new
        // CumQty(1000000),
        // new AvgPx(5.57765));
        // SessionID sessionID = new SessionID("FIX.4.4", "EXEC", "BANZAI");
        // OnBehalfOfCompID onBehalfOfCompId = new OnBehalfOfCompID("FX");

        ExecutionReport executionReport = new ExecutionReport(
                new OrderID("3-2-805331618T-0-0"),
                new ExecID("3-2-805331618T-0-0"),
                new ExecType(ExecType.TRADE),
                new OrdStatus(OrdStatus.FILLED),
                new Side(Side.BUY),
                new LeavesQty(0),
                new CumQty(1000000));

        executionReport.set(new TransactTime());
        executionReport.set(new SettlType(SettlType.REGULAR_FX_SPOT_SETTLEMENT));
        executionReport.set(new SettlDate("20201016"));
        executionReport.set(new OrderQty(1000000));
        executionReport.set(new Spread(0));
        executionReport.set(new OrdType(OrdType.MARKET));
        executionReport.set(new Product(Product.CURRENCY));
        // executionReport.set(new
        // TradePublishIndicator(TradePublishIndicator.DO_NOT_PUBLISH_TRADE));
        executionReport.set(new ClOrdID("3-2-805331618T-0-0"));
        // executionReport.set(new StrikeTime(null));
        // executionReport.set(new OfferPx(5.57765));
        executionReport.set(new Symbol("USD/BRL"));
        // message.setString(23001, "Zinc");
        executionReport.setField(new StringField(23001, "Zinc"));
        executionReport.setField(new StringField(23002, "12.03"));
        executionReport.setField(new StringField(23003, "3.65"));

        return executionReport;

    }

    public static ExecutionReport getExecMessage() {
        ExecutionReport exe = new ExecutionReport();
        // genOrderID(), genExecID(), new ExecType(ExecType.TRADE), new OrdStatus(
        // OrdStatus.FILLED),
        // Side.SELL, new LeavesQty(0), new CumQty(
        // orderQty.getValue()));;

        exe.set(genOrderID());
        exe.set(genExecID());
        exe.set(new ExecType(ExecType.NEW));
        exe.set(new OrdStatus(OrdStatus.FILLED));
        exe.set(new Side(Side.SELL));
        exe.set(new LeavesQty(0));
        exe.set(new CumQty(12));

        // exe.setString(23001, "Zinc");
        // exe.setString(23002, "12.03");
        // exe.setString(23003, "3.65");

        return exe;
    }

    public static Message getExecution() {

        Message message = new Message();

        Header header = message.getHeader();

        // header.setField(new BeginString("FIXT.1.1"));
        // header.setField(new SenderCompID("SERVER"));
        // header.setField(new TargetCompID("CLIENT"));
        header.setField(new MsgType("8"));

        message.setField(new OrderID("123456"));
        message.setField(new ExecID("1245"));
        message.setField(new ExecType('F'));
        message.setField(new Side('1'));
        message.setField(new OrdStatus('2'));
        message.setField(new LeavesQty(125));
        message.setField(new CumQty(12));

        message.setString(11, "468055");
        message.setString(38, "400000");
        message.setString(31, ".37");
        message.setString(40, "1");
        message.setString(55, "EUR");
        // message.setString(60, LocalDateTime.now().toString());
        message.setString(64, "20221120");

        message.setString(423, "1");
        message.setString(37, "refinitiv_g4");
        message.setString(17, "604011978");
        message.setChar(150, 'F');
        message.setString(39, "2");
        message.setString(54, "1");

        // message.setString(452, "1");
        // message.setString(453, "19981231-23:59:60"); //StrikeTime
        // message.setChar(447, 'C');
        // message.setString(448, "GFHIBHBM");

        message.setString(1, "account");
        message.setString(22, "2");
        message.setString(541, "20221130");
        message.setString(58, "Fixed Murabaha");
        message.setString(23001, "Zinc");
        message.setString(23002, "12.03");
        message.setString(23003, "3.65");
        message.setString(15, "EUR");
        message.setString(32, "1000000");

        message.setString(151, "1000000");
        message.setString(14, "1000000");

        return message;

    }
}
