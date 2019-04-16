package deepnetts.net.layers.activation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zoran
 */
public class TanhTest {
    private Tanh instance;
    
    @Before
    public void setUp() {
        instance = new Tanh();
    }
 

    /**
     * Test of getValue method, of class Tanh.
     */
    @Test
    public void testGetValue() {
        float[] x = {-7.0f,  -6.9f,  -6.8f,  -6.7f,  -6.6f,  -6.5f,  -6.4f,  -6.3f,  -6.2f,  -6.1f,  -6.0f,  -5.9f,  -5.8f,  -5.7f,  -5.6f,  -5.5f,  -5.4f,  -5.3f,  -5.2f,  -5.1f,  -5.0f,  -4.9f,  -4.8f,  -4.7f,  -4.6f,  -4.5f,  -4.4f,  -4.3f,  -4.2f,  -4.1f,  -4.0f,  -3.9f,  -3.8f,  -3.7f,  -3.6f,  -3.5f,  -3.4f,  -3.3f,  -3.2f,  -3.1f,  -3.0f,  -2.9f,  -2.8f,  -2.7f,  -2.6f,  -2.5f,  -2.4f,  -2.3f,  -2.2f,  -2.1f,  -2.0f,  -1.9f,  -1.8f,  -1.7f,  -1.6f,  -1.5f,  -1.4f,  -1.3f,  -1.2f,  -1.1f,  -1.0f,  -0.9f,  -0.8f,  -0.7f,  -0.6f,  -0.5f,  -0.4f,  -0.3f,  -0.2f,  -0.1f,  0f,  0.1f,  0.2f,  0.3f,  0.4f,  0.5f,  0.6f,  0.7f,  0.8f,  0.9f,  1.0f,  1.1f,  1.2f,  1.3f,  1.4f,  1.5f,  1.6f,  1.7f,  1.8f,  1.9f,  2.0f,  2.1f,  2.2f,  2.3f,  2.4f,  2.5f,  2.6f,  2.7f,  2.8f,  2.9f,  3.0f,  3.1f,  3.2f,  3.3f,  3.4f,  3.5f,  3.6f,  3.7f,  3.8f,  3.9f,  4.0f,  4.1f,  4.2f,  4.3f,  4.4f,  4.5f,  4.6f,  4.7f,  4.8f,  4.9f,  5.0f,  5.1f,  5.2f,  5.3f,  5.4f,  5.5f,  5.6f,  5.7f,  5.8f,  5.9f,  6.0f,  6.1f,  6.2f,  6.3f,  6.4f,  6.5f,  6.6f,  6.7f,  6.8f,  6.9f,  7.0f};
        float[] y = {-0.99999833f,  -0.999998f,  -0.9999975f,  -0.99999696f,  -0.9999963f,  -0.99999547f,  -0.99999446f,  -0.99999326f,  -0.9999918f,  -0.9999899f,  -0.9999877f,  -0.999985f,  -0.99998164f,  -0.9999776f,  -0.99997264f,  -0.9999666f,  -0.99995923f,  -0.9999502f,  -0.99993914f,  -0.9999257f,  -0.9999092f,  -0.9998891f,  -0.9998646f,  -0.99983454f,  -0.99979794f,  -0.99975324f,  -0.9996986f,  -0.9996319f,  -0.99955034f,  -0.99945086f,  -0.9993293f,  -0.99918085f,  -0.9989996f,  -0.9987782f,  -0.9985079f,  -0.9981779f,  -0.9977749f,  -0.997283f,  -0.9966824f,  -0.9959494f,  -0.9950548f,  -0.9939632f,  -0.9926315f,  -0.99100745f,  -0.9890274f,  -0.9866143f,  -0.9836749f,  -0.9800964f,  -0.9757431f,  -0.97045195f,  -0.9640276f,  -0.95623744f,  -0.946806f,  -0.93540907f,  -0.9216685f,  -0.90514827f,  -0.88535166f,  -0.8617232f,  -0.8336546f,  -0.800499f,  -0.7615942f,  -0.71629786f,  -0.66403675f,  -0.6043678f,  -0.5370496f,  -0.46211717f,  -0.37994897f,  -0.2913126f,  -0.19737533f,  -0.099667996f,  -2.4868996e-14f,  0.099667996f,  0.19737533f,  0.2913126f,  0.37994897f,  0.46211717f,  0.5370496f,  0.6043678f,  0.66403675f,  0.71629786f,  0.7615942f,  0.800499f,  0.8336546f,  0.8617232f,  0.88535166f,  0.90514827f,  0.9216685f,  0.93540907f,  0.946806f,  0.95623744f,  0.9640276f,  0.97045195f,  0.9757431f,  0.9800964f,  0.9836749f,  0.9866143f,  0.9890274f,  0.99100745f,  0.9926315f,  0.9939632f,  0.9950548f,  0.9959494f,  0.9966824f,  0.997283f,  0.9977749f,  0.9981779f,  0.9985079f,  0.9987782f,  0.9989996f,  0.99918085f,  0.9993293f,  0.99945086f,  0.99955034f,  0.9996319f,  0.9996986f,  0.99975324f,  0.99979794f,  0.99983454f,  0.9998646f,  0.9998891f,  0.9999092f,  0.9999257f,  0.99993914f,  0.9999502f,  0.99995923f,  0.9999666f,  0.99997264f,  0.9999776f,  0.99998164f,  0.999985f,  0.9999877f,  0.9999899f,  0.9999918f,  0.99999326f,  0.99999446f,  0.99999547f,  0.9999963f,  0.99999696f,  0.9999975f,  0.999998f,  0.99999833f};
           // numpy: -0.99999833f,  -0.999998f,  -0.9999975f,  -0.99999696f,  -0.9999963f,  -0.99999547f,  -0.99999446f,  -0.99999326f,  -0.9999918f,  -0.9999899f,  -0.9999877f,  -0.999985f,  -0.99998164f,  -0.9999776f,  -0.99997264f,  -0.9999666f,  -0.99995923f,  -0.9999502f,  -0.99993914f,  -0.9999257f,  -0.9999092f,  -0.9998891f,  -0.9998646f,  -0.99983454f,  -0.99979794f,  -0.99975324f,  -0.9996986f,  -0.9996319f,  -0.99955034f,  -0.99945086f,  -0.9993293f,  -0.99918085f,  -0.9989996f,  -0.9987782f,  -0.9985079f,  -0.9981779f,  -0.9977749f,  -0.997283f,  -0.9966824f,  -0.9959494f,  -0.9950548f,  -0.9939632f,  -0.9926315f,  -0.99100745f,  -0.9890274f,  -0.9866143f,  -0.9836749f,  -0.9800964f,  -0.9757431f,  -0.97045195f,  -0.9640276f,  -0.95623744f,  -0.946806f,  -0.93540907f,  -0.9216685f,  -0.90514827f,  -0.88535166f,  -0.8617232f,  -0.8336546f,  -0.800499f,  -0.7615942f,  -0.71629786f,  -0.66403675f,  -0.6043678f,  -0.5370496f,  -0.46211717f,  -0.37994897f,  -0.2913126f,  -0.19737533f,  -0.099667996f,  -2.4868996e-14f,  0.099667996f,  0.19737533f,  0.2913126f,  0.37994897f,  0.46211717f,  0.5370496f,  0.6043678f,  0.66403675f,  0.71629786f,  0.7615942f,  0.800499f,  0.8336546f,  0.8617232f,  0.88535166f,  0.90514827f,  0.9216685f,  0.93540907f,  0.946806f,  0.95623744f,  0.9640276f,  0.97045195f,  0.9757431f,  0.9800964f,  0.9836749f,  0.9866143f,  0.9890274f,  0.99100745f,  0.9926315f,  0.9939632f,  0.9950548f,  0.9959494f,  0.9966824f,  0.997283f,  0.9977749f,  0.9981779f,  0.9985079f,  0.9987782f,  0.9989996f,  0.99918085f,  0.9993293f,  0.99945086f,  0.99955034f,  0.9996319f,  0.9996986f,  0.99975324f,  0.99979794f,  0.99983454f,  0.9998646f,  0.9998891f,  0.9999092f,  0.9999257f,  0.99993914f,  0.9999502f,  0.99995923f,  0.9999666f,  0.99997264f,  0.9999776f,  0.99998164f,  0.999985f,  0.9999877f,  0.9999899f,  0.9999918f,  0.99999326f,  0.99999446f,  0.99999547f,  0.9999963f,  0.99999696f,  0.9999975f,  0.999998f,  0.99999833f,         
        
        for (int i = 0; i < x.length; i++) {
            float expResult = y[i];
            float result = instance.getValue(x[i]);
            assertEquals(expResult, result, 1e-6);
        }    
    }

    /**
     * Test of getPrime method, of class Tanh.
     */
    @Test
    public void testGetPrime() {
        float[] x = {-0.999998f,  -0.999998f,  -0.999997f,  -0.999997f,  -0.999996f,  -0.999995f,  -0.999994f,  -0.999993f,  -0.999992f,  -0.99999f,  -0.999988f,  -0.999985f,  -0.999982f,  -0.999978f,  -0.999973f,  -0.999967f,  -0.999959f,  -0.99995f,  -0.999939f,  -0.999926f,  -0.999909f,  -0.999889f,  -0.999865f,  -0.999835f,  -0.999798f,  -0.999753f,  -0.999699f,  -0.999632f,  -0.99955f,  -0.999451f,  -0.999329f,  -0.999181f,  -0.999f,  -0.998778f,  -0.998508f,  -0.998178f,  -0.997775f,  -0.997283f,  -0.996682f,  -0.995949f,  -0.995055f,  -0.993963f,  -0.992631f,  -0.991007f,  -0.989027f,  -0.986614f,  -0.983675f,  -0.980096f,  -0.975743f,  -0.970452f,  -0.964028f,  -0.956237f,  -0.946806f,  -0.935409f,  -0.921669f,  -0.905148f,  -0.885352f,  -0.861723f,  -0.833655f,  -0.800499f,  -0.761594f,  -0.716298f,  -0.664037f,  -0.604368f,  -0.53705f,  -0.462117f,  -0.379949f,  -0.291313f,  -0.197375f,  -0.099668f,  -2.4869e-14f,  0.099668f,  0.197375f,  0.291313f,  0.379949f,  0.462117f,  0.53705f,  0.604368f,  0.664037f,  0.716298f,  0.761594f,  0.800499f,  0.833655f,  0.861723f,  0.885352f,  0.905148f,  0.921669f,  0.935409f,  0.946806f,  0.956237f,  0.964028f,  0.970452f,  0.975743f,  0.980096f,  0.983675f,  0.986614f,  0.989027f,  0.991007f,  0.992631f,  0.993963f,  0.995055f,  0.995949f,  0.996682f,  0.997283f,  0.997775f,  0.998178f,  0.998508f,  0.998778f,  0.999f,  0.999181f,  0.999329f,  0.999451f,  0.99955f,  0.999632f,  0.999699f,  0.999753f,  0.999798f,  0.999835f,  0.999865f,  0.999889f,  0.999909f,  0.999926f,  0.999939f,  0.99995f,  0.999959f,  0.999967f,  0.999973f,  0.999978f,  0.999982f,  0.999985f,  0.999988f,  0.99999f,  0.999992f,  0.999993f,  0.999994f,  0.999995f,  0.999996f,  0.999997f,  0.999997f,  0.999998f,  0.999998f};
        float[] y = {3.3261094e-06f,  4.0625177e-06f,  4.961968e-06f,  6.060558e-06f,  7.4023774e-06f,  9.041277e-06f,  1.1043029e-05f,  1.348797e-05f,  1.647422e-05f,  2.012162e-05f,  2.4576548e-05f,  3.0017782e-05f,  3.6663678e-05f,  4.4780936e-05f,  5.4695287e-05f,  6.680457e-05f,  8.1594684e-05f,  9.9659075e-05f,  0.00012172252f,  0.00014867022f,  0.00018158324f,  0.0002217818f,  0.00027087826f,  0.00033084152f,  0.00040407595f,  0.0004935174f,  0.0006027506f,  0.0007361521f,  0.00089906494f,  0.001098011f,  0.0013409507f,  0.0016375977f,  0.0019998036f,  0.0024420246f,  0.002981889f,  0.0036408848f,  0.0044451933f,  0.0054266974f,  0.006624198f,  0.008084874f,  0.009866037f,  0.012037222f,  0.0146826655f,  0.017904228f,  0.021824798f,  0.026592227f,  0.032383773f,  0.039411053f,  0.047925346f,  0.05822304f,  0.07065082f,  0.08560992f,  0.10355838f,  0.12500986f,  0.15052707f,  0.18070664f,  0.21615246f,  0.2574332f,  0.30502f,  0.3592013f,  0.41997433f,  0.48691735f,  0.55905515f,  0.6347396f,  0.7115778f,  0.7864477f,  0.8556388f,  0.91513693f,  0.961043f,  0.9900663f,  1.0f,  0.9900663f,  0.961043f,  0.91513693f,  0.8556388f,  0.7864477f,  0.7115778f,  0.6347396f,  0.55905515f,  0.48691735f,  0.41997433f,  0.3592013f,  0.30502f,  0.2574332f,  0.21615246f,  0.18070664f,  0.15052707f,  0.12500986f,  0.10355838f,  0.08560992f,  0.07065082f,  0.05822304f,  0.047925346f,  0.039411053f,  0.032383773f,  0.026592227f,  0.021824798f,  0.017904228f,  0.0146826655f,  0.012037222f,  0.009866037f,  0.008084874f,  0.006624198f,  0.0054266974f,  0.0044451933f,  0.0036408848f,  0.002981889f,  0.0024420246f,  0.0019998036f,  0.0016375977f,  0.0013409507f,  0.001098011f,  0.00089906494f,  0.0007361521f,  0.0006027506f,  0.0004935174f,  0.00040407595f,  0.00033084152f,  0.00027087826f,  0.0002217818f,  0.00018158324f,  0.00014867022f,  0.00012172252f,  9.9659075e-05f,  8.1594684e-05f,  6.680457e-05f,  5.4695287e-05f,  4.4780936e-05f,  3.6663678e-05f,  3.0017782e-05f,  2.4576548e-05f,  2.012162e-05f,  1.647422e-05f,  1.348797e-05f,  1.1043029e-05f,  9.041277e-06f,  7.4023774e-06f,  6.060558e-06f,  4.961968e-06f,  4.0625177e-06f,  3.3261094e-06f};
//        float[] y = {3.32611e-06f,  4.06252e-06f,  4.96197e-06f,  6.06056e-06f,  7.40238e-06f,  9.04128e-06f,  1.1043e-05f,  1.3488e-05f,  1.64742e-05f,  2.01216e-05f,  2.45765e-05f,  3.00178e-05f,  3.66637e-05f,  4.47809e-05f,  5.46953e-05f,  6.68046e-05f,  8.15947e-05f,  9.96591e-05f,  0.000121723f,  0.00014867f,  0.000181583f,  0.000221782f,  0.000270878f,  0.000330842f,  0.000404076f,  0.000493517f,  0.000602751f,  0.000736152f,  0.000899065f,  0.00109801f,  0.00134095f,  0.0016376f,  0.0019998f,  0.00244202f,  0.00298189f,  0.00364088f,  0.00444519f,  0.0054267f,  0.0066242f,  0.00808487f,  0.00986604f,  0.0120372f,  0.0146827f,  0.0179042f,  0.0218248f,  0.0265922f,  0.0323838f,  0.0394111f,  0.0479253f,  0.058223f,  0.0706508f,  0.0856099f,  0.103558f,  0.12501f,  0.150527f,  0.180707f,  0.216152f,  0.257433f,  0.30502f,  0.359201f,  0.419974f,  0.486917f,  0.559055f,  0.63474f,  0.711578f,  0.786448f,  0.855639f,  0.915137f,  0.961043f,  0.990066f,  1.0f,  0.990066f,  0.961043f,  0.915137f,  0.855639f,  0.786448f,  0.711578f,  0.63474f,  0.559055f,  0.486917f,  0.419974f,  0.359201f,  0.30502f,  0.257433f,  0.216152f,  0.180707f,  0.150527f,  0.12501f,  0.103558f,  0.0856099f,  0.0706508f,  0.058223f,  0.0479253f,  0.0394111f,  0.0323838f,  0.0265922f,  0.0218248f,  0.0179042f,  0.0146827f,  0.0120372f,  0.00986604f,  0.00808487f,  0.0066242f,  0.0054267f,  0.00444519f,  0.00364088f,  0.00298189f,  0.00244202f,  0.0019998f,  0.0016376f,  0.00134095f,  0.00109801f,  0.000899065f,  0.000736152f,  0.000602751f,  0.000493517f,  0.000404076f,  0.000330842f,  0.000270878f,  0.000221782f,  0.000181583f,  0.00014867f,  0.000121723f,  9.96591e-05f,  8.15947e-05f,  6.68046e-05f,  5.46953e-05f,  4.47809e-05f,  3.66637e-05f,  3.00178e-05f,  2.45765e-05f,  2.01216e-05f,  1.64742e-05f,  1.3488e-05f,  1.1043e-05f,  9.04128e-06f,  7.40238e-06f,  6.06056e-06f,  4.96197e-06f,  4.06252e-06f,  3.32611e-06f};
                      
        for (int i = 0; i < x.length; i++) {
            float expResult = y[i];
            float result = instance.getPrime(x[i]);
            assertEquals(expResult, result, 1e-6);
        }  
    }
    
    
}