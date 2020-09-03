package com.sannikov.steps;

import com.sannikov.objects.InstrNewsPage;
import org.springframework.stereotype.Component;

@Component
public class InstrNewsPageSteps extends BasePageSteps {
    private static final ThreadLocal<InstrNewsPage> INSTR_NEWS_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private InstrNewsPage getInstrNewsPage(){
        return INSTR_NEWS_PAGE_THREAD_LOCAL.get();
    }

    public void setInstrNewsPage(InstrNewsPage instrNewsPage){
        INSTR_NEWS_PAGE_THREAD_LOCAL.set(instrNewsPage);
    }
}
