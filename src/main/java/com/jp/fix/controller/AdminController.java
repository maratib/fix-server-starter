package com.jp.fix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.fix.FixApplication;

@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping
    public String home() {

        // Message message = new Message();

        // Header header = message.getHeader();

        // header.setField(new BeginString("FIXT.1.1"));
        // header.setField(new SenderCompID("SERVER"));
        // header.setField(new TargetCompID("CLIENT"));
        // header.setField(new MsgType("8"));

        // message.setField(new OrderID("123456"));
        // message.setField(new ExecID("1245"));
        // message.setField(new ExecType('F'));
        // message.setField(new Side('1'));
        // message.setField(new OrdStatus('2'));
        // message.setField(new LeavesQty(125));
        // message.setField(new CumQty(12));

        // message.setString(11, "468055");
        // message.setString(38, "400000");
        // message.setString(31, ".37");
        // message.setString(40, "1");
        // message.setString(55, "EUR");
        // // message.setUtcDateOnly(60, LocalDate.now());
        // // message.setString(64, "20221120");
        // message.setString(423, "1");
        // message.setString(37, "refinitiv_g4");
        // message.setString(17, "604011978");
        // message.setString(150, "F");
        // message.setString(39, "2");
        // message.setString(54, "1");
        // message.setString(453, "2");
        // message.setString(448, "GFHIBHBM");
        // message.setString(447, "B");
        // message.setString(452, "1");
        // message.setString(448, "e10680");
        // message.setString(447, "C");
        // message.setString(452, "11");
        // message.setString(1, "account");
        // message.setString(22, "2");
        // message.setString(541, "20221130");
        // message.setString(58, "Fixed Murabaha");
        // message.setString(23001, "Zinc");
        // message.setString(23002, "12.03");
        // message.setString(23003, "3.65");
        // message.setString(15, "EUR");
        // message.setString(32, "1000000");

        // message.setString(151, "1000000");
        // message.setString(14, "1000000");

        // try {
        // Session.sendToTarget(message);
        // } catch (SessionNotFound e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        return "Admin version : " + FixApplication.appVersion;
    }

    @GetMapping("start")
    public String start() {
        return "Starting...";
    }
}
