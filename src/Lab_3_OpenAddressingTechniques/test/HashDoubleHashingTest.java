package Lab_3_OpenAddressingTechniques.test;

import Lab_3_OpenAddressingTechniques.implementation.HashLinearProbing;
import Lab_3_OpenAddressingTechniques.implementation.HashDoubleHashing;

public class HashDoubleHashingTest extends GeneralHashTableTest<String> {

    public HashDoubleHashingTest() {
        super(new HashDoubleHashing<>(2037));
    }
}

