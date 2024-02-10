package org.frc6090.lib.datasystem;

public interface DataSystemInterface {

    /**
     * update
     */
    default void update() {}

    /**
     * simUpdate
     */
    default void simUpdate() {}

    /**
     * getName
     * 
     * @return name
     */
    default String getName() {
        return this.getClass().getSimpleName();
    }
}
