package org.frc6090.lib.datasystem;

import java.util.HashMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;

public class DataSystemBase { /* DataSystem */
  
    private static DataSystemBase m_DataSystemBase;

    private static HashMap<DataSystem, Runnable> m_DataSystemsMap = new HashMap<>();

    public DataSystemBase() {
      
    }

    public static DataSystemBase getInstance() {
      if (m_DataSystemBase == null) {
        m_DataSystemBase = new DataSystemBase();
      }
      return m_DataSystemBase;
    }
    
    public void registerDatasystem(DataSystem... dataSystems) {
      for (DataSystem dataSystem : dataSystems) {
        if (dataSystem == null) {
          DriverStation.reportWarning("Tried to register a null datasystem", true);
          continue;
        }
        if (m_DataSystemsMap.containsKey(dataSystem)) {
          DriverStation.reportWarning("Tried to register an already-registered datasystem", true);
          continue;
        }
        m_DataSystemsMap.put(dataSystem, null);
      }
    }

    public static void runUpdates() {
        DataLooper.runUpdates();
        for (DataSystem dataSystem : m_DataSystemsMap.keySet()) {
            dataSystem.update();
            if (RobotBase.isSimulation()) {
                dataSystem.simUpdate();
            }
        }
    }

}
