package org.frc6090.lib.datasystem;

public abstract class DataSystem implements DataSystemInterface {
    
    public DataSystem() {
        DataSystemBase.getInstance().registerDatasystem(this);
    }

}
