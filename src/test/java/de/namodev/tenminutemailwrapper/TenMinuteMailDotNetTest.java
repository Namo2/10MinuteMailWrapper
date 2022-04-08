package de.namodev.tenminutemailwrapper;

import de.namodev.tenminutemailwrapper.models.MailResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TenMinuteMailDotNetTest {
    private TenMinuteMailDotNet tenMinuteMailDotNet;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        tenMinuteMailDotNet = new TenMinuteMailDotNet();
        tenMinuteMailDotNet.getEmail();
    }

    @org.junit.jupiter.api.Test
    void generateNewEmailAddress() {
        String currentMailAddress = tenMinuteMailDotNet.getEmail().getAddress();

        tenMinuteMailDotNet.generateNewEmailAddress();

        assertNotEquals(currentMailAddress, tenMinuteMailDotNet.getEmail().getAddress());
    }

    @org.junit.jupiter.api.Test
    void recoverLastEmailAddress() {
        String currentMailAddress = tenMinuteMailDotNet.getEmail().getAddress();

        tenMinuteMailDotNet.generateNewEmailAddress();

        assertNotEquals(currentMailAddress, tenMinuteMailDotNet.getEmail().getAddress());

        tenMinuteMailDotNet.recoverLastEmailAddress();

        assertEquals(currentMailAddress, tenMinuteMailDotNet.getEmail().getAddress());
    }

    @org.junit.jupiter.api.Test
    void reset10Minutes() {
        tenMinuteMailDotNet.resetTo10Minutes();

        MailResponse mailResponse = tenMinuteMailDotNet.getEmail();

        int expectedTimeLeft = 600;
        int acceptableOffset = 2; // 2 seconds due to the time it takes to get the new email response

        assertTrue(mailResponse.getTimeLeft() > expectedTimeLeft - acceptableOffset);
    }

    @org.junit.jupiter.api.Test
    void reset100Minutes() {
        tenMinuteMailDotNet.resetTo100Minutes();

        MailResponse mailResponse = tenMinuteMailDotNet.getEmail();

        int expectedTimeLeft = 6000;
        int acceptableOffset = 2; // 2 seconds due to the time it takes to get the new email response

        assertTrue(mailResponse.getTimeLeft() > expectedTimeLeft - acceptableOffset);
    }
}
