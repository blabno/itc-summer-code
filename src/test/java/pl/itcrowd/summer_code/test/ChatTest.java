package pl.itcrowd.summer_code.test;

import org.junit.Test;

public class ChatTest {
    /**TERMS
     * Validates a click on 'chat' button and functionality popup window.
     * SCENARIO
     * Logged user has entered on a homepage. User clicks on 'chat' button and chooses option 'chat for free'.
     * EXPECTED
     * User will be waiting for confirmation from physic and if physic will agreed 'chat window' will displayed.
     * If physic will not confirmed dialog then popup message will displayed with text " 'physic nickname' declined your chat proposition." */
     @Test
     public void chatForFreeTest(){
     }
    /**TERMS
     * Validates a click on 'chat' button and functionality popup window.
     * SCENARIO
     * Logged user has entered on a homepage. User clicks on 'chat' button and chooses option 'No'.
     * EXPECTED
     * Popup window will disappeared. */
    @Test
    public void chatExitTest(){
    }
    /**TERMS
     * Validates a click on 'chat' button and functionality popup window.
     * SCENARIO
     * Logged user has entered on a homepage. User clicks on 'chat' button and chooses option 'Yes'.
     * EXPECTED
     * Popup window will showed current price for every minute chat. User will be waiting for confirmation from physic
     * and if physic will agreed 'chat window' will displayed. If physic will not confirmed dialog then popup message
     * will displayed with text " 'physic nickname' declined your chat proposition." */
    @Test
    public void chatForCreditsTest(){
    }
}
