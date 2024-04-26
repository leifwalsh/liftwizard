package com.puppycrawl.tools.checkstyle;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Custom Checkstyle Check that formats output as GitHub annotations.
 */
public class GitHubAnnotationCheck extends AbstractCheck {

    /**
     * A key is pointing to the warning message text in "messages.properties" file.
     */
    private static final String MSG_KEY = "github.annotation.error";

    @Override
    public int[] getDefaultTokens() {
        return new int[0]; // This check will not be interested in specific token types.
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[0]; // This check will not be interested in specific token types.
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[0]; // This check will not be interested in specific token types.
    }

    @Override
    public void beginTree(DetailAST rootAST) {
        // No action taken on the beginning of a tree.
    }

    @Override
    public void visitToken(DetailAST ast) {
        // No action taken on visiting tokens, as this check does not process specific tokens.
    }

    @Override
    public void finishTree(DetailAST rootAST) {
        // No action taken on the finish of a tree.
    }

    /**
     * Logs a Checkstyle error as a GitHub annotation.
     *
     * @param line the line number where the error occurred
     * @param col the column number where the error occurred
     * @param key the key to the error message
     * @param args the arguments for the error message
     */
    public void logError(int line, int col, String key, Object... args) {
        // Format the error message as a GitHub annotation.
        String baseName = getMessageBundle();
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.getDefault());
        String message = bundle.getString(key);
        String formattedMessage = String.format(message, args);
        String annotation = String.format("::error file=%s,line=%d,col=%d::%s",
                getFileContents().getFileName(), line, col, formattedMessage);
        System.out.println(annotation);
    }

    /**
     * Logs a Checkstyle error as a GitHub annotation without column information.
     *
     * @param line the line number where the error occurred
     * @param key the key to the error message
     * @param args the arguments for the error message
     */
    public void logError(int line, String key, Object... args) {
        // Format the error message as a GitHub annotation.
        String baseName = getMessageBundle();
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.getDefault());
        String message = bundle.getString(key);
        String formattedMessage = String.format(message, args);
        String annotation = String.format("::error file=%s,line=%d::%s",
                getFileContents().getFileName(), line, formattedMessage);
        System.out.println(annotation);
    }
}
