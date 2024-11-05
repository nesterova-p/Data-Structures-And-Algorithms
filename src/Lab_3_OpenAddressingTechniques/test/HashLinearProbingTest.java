package Lab_3_OpenAddressingTechniques.test;

import Lab_3_OpenAddressingTechniques.implementation.HashLinearProbing;
import Lab_3_OpenAddressingTechniques.implementation.HashDoubleHashing;

public class HashLinearProbingTest extends GeneralHashTableTest<String> {

    public HashLinearProbingTest() {
        super(new HashLinearProbing<>(2037));
    }
}
