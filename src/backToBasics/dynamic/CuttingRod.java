package backToBasics.dynamic;

import java.util.Map;

public class CuttingRod {

    private Map mPriceLookUpMap;

    private int mTotalLength;

    CuttingRod(Map<Integer, Integer> priceLookUp, int totalLength) {

        mPriceLookUpMap = priceLookUp;

        mTotalLength = totalLength;
    }

}
