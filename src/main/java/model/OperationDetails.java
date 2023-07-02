package main.java.model;

public class OperationDetails {

    private String firstOperand;
    private String secondOperand;
    private String operationType;
    private boolean isRoman;

    public OperationDetails() {
    }

    public String getFirstOperand() {
        return firstOperand;
    }

    public String getSecondOperand() {
        return secondOperand;
    }

    public String getOperationType() {
        return operationType;
    }

    public boolean isRoman() {
        return isRoman;
    }

    public void setFirstOperand(String firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(String secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setRoman(boolean roman) {
        isRoman = roman;
    }
}
