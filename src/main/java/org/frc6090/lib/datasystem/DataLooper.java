package org.frc6090.lib.datasystem;

import java.util.HashMap;

public class DataLooper { /* DataLooper */

    private static boolean enabled = false;

    public static void SetEnabled() {
        enabled = true;
    }

    private static HashMap<Integer, Runnable> m_DataLooperMap = new HashMap<>();

    public static void AddDataLoop(Runnable run) {
        m_DataLooperMap.put(m_DataLooperMap.size(), run);
    }

    public static void runUpdates() {
        if (enabled)
            for (int i = 0; i < m_DataLooperMap.size(); i++) {
                m_DataLooperMap.get(i).run();
            }
    }

}
