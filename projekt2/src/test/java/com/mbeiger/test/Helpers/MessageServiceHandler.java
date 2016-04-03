package com.mbeiger.test.Helpers;

import com.mbeiger.ConnectionStatus;
import com.mbeiger.MalformedRecipientException;
import com.mbeiger.SendingStatus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MessageServiceHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("checkConnection".equals(method.getName())) {
            if (args[0].toString().matches("[a-z].*.pl$")) {
                return ConnectionStatus.SUCCESS;
            } else {
                return ConnectionStatus.FAILURE;
            }
        }

        if ("send".equals(method.getName())) {

            if (args[0].toString().length() < 3 || args[1].toString().length() < 4)
                throw new MalformedRecipientException();

            if (!args[0].toString().matches("[a-z].*.pl$")) {
                return SendingStatus.SENDING_ERROR;
            }

            return SendingStatus.SENDING_ERROR;


        }

        return 5;
    }
}