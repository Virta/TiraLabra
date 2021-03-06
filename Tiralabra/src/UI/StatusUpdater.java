/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Encoding.Compressor;
import Encoding.Decompressor;
import Encoding.StatusEnum;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * A runnable class for updating the status of either the compression or decompression.
 * @author virta
 */
public class StatusUpdater implements Runnable {

    /**
     * Compressor from which status is queried.
     */
    private Compressor compressor;
    
    /**
     * Decompressor from which status is queried.
     */
    private Decompressor decompressor;
    
    /**
     * Label for compression satus.
     */
    private JTextArea compressionSatus;
    
    /**
     * Label for decompression status.
     */
    private JTextArea decompressionStatus;
    
    /**
     * Tells an instance of this class whether to update the comressor or decompressor stauts.
     */
    private boolean isCompressor;
    
    /**
     * For interruption.
     */
    private boolean interrupt;
    
    /**
     * Having a reference to the listener enables the toggling of buttons when updating loops finish.
     */
    private UIscreenListener listener;
    
    /**
     * Thread label, since many instances of compressor and decompressor may be run simultaneously they need to be named.
     */
    private int thread;

    public StatusUpdater(Compressor compressor, Decompressor decompressor, JTextArea compressionSatus, JTextArea decompressionStatus, boolean isCompressor, int thread, UIscreenListener listener) {
        if (isCompressor) {
            this.compressor = compressor;
            this.compressionSatus = compressionSatus;
        } else {
            this.decompressionStatus = decompressionStatus;
            this.decompressor = decompressor;
        }
        this.listener = listener;
        this.isCompressor = isCompressor;
        this.interrupt = false;
        this.thread = thread;
    }

    public void interrupt() {
        this.interrupt = true;
    }

    /**
     * Calls the appropriate loop for the updater. When loop finishes toggles the appropriate buttons for the GUI.
     */
    @Override
    public void run() {
        if (isCompressor) {
            loopCompressionStatus();
            listener.toggleCompressorButtons(true);
        } else {
            loopDecompressionStatus();
            listener.toggleDecompressorButtons(true);
        }
    }

    /**
     * Catenates to the text currently displayed the status.
     * @param field
     * @param status 
     */
    private void printStatus(JTextArea field, StatusEnum status) {
        String statusText = field.getText();
        if (field.getRows()>20){
            statusText ="";
        }
        switch (status) {
            case BUILDING:
                statusText+=thread+": Analyzing\n";
                break;
            case DATAERROR:
                statusText+=thread+": Error in data\n";
                interrupt = true;
                break;
            case DECODING:
                statusText+=thread+": Decoding data\n";
                break;
            case ENCODING:
                statusText+=thread+": Encoding\n";
                break;
            case EXTRACTING:
                statusText+=thread+": Extracing fields\n";
                break;
            case INTERRUPTED:
                statusText+=thread+": Interrupted\n";
                interrupt = true;
                break;
        }
        field.setText(statusText);
    }

    /**
     * While not interrupted loops every 500 ms to update the status of compression.
     * @return 
     */
    private boolean loopCompressionStatus() {
        StatusEnum status = compressor.queryStatus();
        while (!status.equals(StatusEnum.DONE)) {
            printStatus(compressionSatus, status);
            status = compressor.queryStatus();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                return true;
            }
            if (interrupt) {
                printStatus(compressionSatus, status);
                return true;
            }
        }
        return false;
    }

    /**
     * While not interrupted loops every 500 ms to update the status of decompression.
     * @return 
     */
    private boolean loopDecompressionStatus() {
        StatusEnum status = decompressor.queryStatus();
        while (!status.equals(StatusEnum.DONE)) {
            printStatus(decompressionStatus, status);
            status = decompressor.queryStatus();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                return true;
            }
            if (interrupt) {
                printStatus(decompressionStatus, status);
                return true;
            }
        }
        return false;
    }
}
