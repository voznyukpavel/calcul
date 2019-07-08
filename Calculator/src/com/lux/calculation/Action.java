package com.lux.calculation;

public enum Action {

    ADD("+", new CalculatePlus()), 
    SUB("-", new CalculateMinus()), 
    MULT("*", new CalculateMulty()), 
    DIV("/", new CalculateDiv());

    private String titile;
    private Calculate calc;

    private Action(String title, Calculate calc) {
        this.titile = title;
        this.calc = calc;
    }

    public String getTitle() {
        return titile;
    }
    
    public double calcExecute(double arg1, double arg2) {
        return calc.act(arg1, arg2);
    }

}
