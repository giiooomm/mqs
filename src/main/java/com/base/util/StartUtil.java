package com.base.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class StartUtil implements ApplicationListener<ContextRefreshedEvent>
{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        if(event.getApplicationContext().getParent() == null)//root application context 没有parent，他就是老大.
        {  
          EhcacheUtil.addCache("lalala", "heiheihei");
        }  
    }

}

