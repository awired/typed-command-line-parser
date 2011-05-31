package net.awired.aclm.argument;

import net.awired.aclm.argument.interfaces.CliArgument;

public class CliArgumentParseException extends Exception {

    /** Serial ID. */
    private static final long serialVersionUID = 1L;

    private CliArgument       currentArgument  = null;
    /** null if not set */
    private Integer           argsNum;
    /** null if not set */
    private Integer           argsPos;

    public CliArgumentParseException(String msg) {
        super(msg);
    }

    public CliArgumentParseException(String msg, int argsNum, int argsPos) {
        super(msg);
        this.argsNum = argsNum;
        this.argsPos = argsPos;
    }

    public CliArgumentParseException(String msg, Exception e) {
        super(msg, e);
    }

    public CliArgumentParseException(String msg, Exception e, int argsNum, int argsPos) {
        super(msg, e);
        this.argsNum = argsNum;
        this.argsPos = argsPos;
    }

    public CliArgumentParseException(String msg, CliArgument current) {
        super(msg);
        currentArgument = current;
    }

    public CliArgumentParseException(String msg, CliArgument current, int argsNum, int argsPos) {
        super(msg);
        currentArgument = current;
        this.argsNum = argsNum;
        this.argsPos = argsPos;
    }

    public CliArgumentParseException(String msg, CliArgument current, Exception e) {
        super(msg, e);
        currentArgument = current;
    }

    public CliArgumentParseException(String msg, CliArgument current, Exception e, int argsNum, int argsPos) {
        super(msg, e);
        currentArgument = current;
        this.argsNum = argsNum;
        this.argsPos = argsPos;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.getMessage());
        if (currentArgument != null) {
            s.append(" -- ");
            s.append(currentArgument);
        }
        return s.toString();
    }

    // ///////////////////////////////////////////////////////////////

    /**
     * @return the currentArgument
     */
    public CliArgument getCurrentArgument() {
        return currentArgument;
    }

    /**
     * @param currentArgument
     *            the currentArgument to set
     */
    public void setCurrentArgument(CliArgument currentArgument) {
        this.currentArgument = currentArgument;
    }

    /**
     * @return the argsNum
     */
    public Integer getArgsNum() {
        return argsNum;
    }

    /**
     * @param argsNum
     *            the argsNum to set
     */
    public void setArgsNum(Integer argsNum) {
        this.argsNum = argsNum;
    }

    /**
     * @return the argsPos
     */
    public Integer getArgsPos() {
        return argsPos;
    }

    /**
     * @param argsPos
     *            the argsPos to set
     */
    public void setArgsPos(Integer argsPos) {
        this.argsPos = argsPos;
    }

}