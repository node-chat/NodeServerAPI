package com.github.nodechatapi.event.testlistener;


import com.github.nodechatapi.event.EventTarget;
import com.github.nodechatapi.event.impl.ConnCloseEvent;
import com.github.nodechatapi.event.impl.UserJoinEvent;
import com.github.nodechatapi.event.impl.UserMessageEvent;

public class ExampleListener {

    @EventTarget
    public void onLeave(ConnCloseEvent event) {
        System.out.println(event.getDisconnectCause().toString());
    }

    @EventTarget
    public void onJoin(UserJoinEvent event) {
        System.out.println(event.getSocket().toString() + "");
    }

    @EventTarget
    public void onMessage(UserMessageEvent event) {

    }

}
