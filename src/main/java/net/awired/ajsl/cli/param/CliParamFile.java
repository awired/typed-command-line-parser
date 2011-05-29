package net.awired.ajsl.cli.param;

import java.io.File;
import net.awired.ajsl.cli.argument.CliArgumentParseException;

public class CliParamFile extends CliParam<File> {

    public CliParamFile(String name) {
        super(name);
    }

    public boolean canRead;
    public boolean canWrite;
    public boolean canExecute;

    public boolean isDirectory;
    public boolean isFile;
    public boolean isHidden;

    @Override
    public File parse(String param) throws CliArgumentParseException {
        // TODO: manage securityexceptions
        File f = new File(param);
        if (canRead && !f.canRead()) {
            throw new CliArgumentParseException(param + " can not be read");
        }
        if (canWrite && !f.canWrite()) {
            throw new CliArgumentParseException(param + " can not be written");
        }
        if (canExecute && !f.canExecute()) {
            throw new CliArgumentParseException(param + " can not be executed");
        }

        if (isDirectory && !f.isDirectory()) {
            throw new CliArgumentParseException(param + " is not a directory");
        }
        if (isFile && !f.isFile()) {
            throw new CliArgumentParseException(param + " is not a file");
        }
        if (isHidden && !f.isHidden()) {
            throw new CliArgumentParseException(param + " is not hidden");
        }
        return f;
    }

    /**
     * @return the canRead
     */
    public Boolean getCanRead() {
        return canRead;
    }

    /**
     * @param canRead
     *            the canRead to set
     */
    public CliParamFile setCanRead(Boolean canRead) {
        this.canRead = canRead;
        return this;
    }

    /**
     * @return the canWrite
     */
    public Boolean getCanWrite() {
        return canWrite;
    }

    /**
     * @param canWrite
     *            the canWrite to set
     */
    public CliParamFile setCanWrite(Boolean canWrite) {
        this.canWrite = canWrite;
        return this;
    }

    /**
     * @return the canExecute
     */
    public Boolean getCanExecute() {
        return canExecute;
    }

    /**
     * @param canExecute
     *            the canExecute to set
     */
    public CliParamFile setCanExecute(Boolean canExecute) {
        this.canExecute = canExecute;
        return this;
    }

    /**
     * @return the isDirectory
     */
    public Boolean getIsDirectory() {
        return isDirectory;
    }

    /**
     * @param isDirectory
     *            the isDirectory to set
     */
    public CliParamFile setIsDirectory(Boolean isDirectory) {
        this.isDirectory = isDirectory;
        return this;
    }

    /**
     * @return the isFile
     */
    public Boolean getIsFile() {
        return isFile;
    }

    /**
     * @param isFile
     *            the isFile to set
     */
    public CliParamFile setIsFile(Boolean isFile) {
        this.isFile = isFile;
        return this;
    }

    /**
     * @return the isHidden
     */
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     * @param isHidden
     *            the isHidden to set
     */
    public CliParamFile setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
        return this;
    }

}
