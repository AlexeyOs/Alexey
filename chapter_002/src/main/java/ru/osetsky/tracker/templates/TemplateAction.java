package ru.osetsky.tracker.templates;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/**
 * Created by koldy on 26.06.2017.
 */
public abstract class TemplateAction {
    public TemplateAction(String name){

    }
    abstract void start();

    abstract void finish();

    public void work() {
        this.start();
        this.finish();
    }
    /**
    public static void main(String[] args) {
        new TemplateAction("String"){
            public void start(){

            }
            public void finish(){

            }
        };
    }
     */
}
