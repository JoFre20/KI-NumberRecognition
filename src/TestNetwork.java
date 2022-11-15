import java.io.IOException;

import MNISTUtilis.MnistImage;
import MNISTUtilis.MnistUtil;
import NeuralNetwork.Layer;
import NeuralNetwork.NeuralNetwork;
import NeuralNetwork.StatUtil;
import Utilis.FileHelper;
import Utilis.JsonHelper;

public class TestNetwork {
	
	final static float TESTNUMBER = 10000;
	
	
    private static NeuralNetwork neuralnetwork = new NeuralNetwork();
	
	public static FileHelper fileHelper = new FileHelper();
	
	public static MnistUtil MUtil;
	
	public static void main(String[] args) throws IOException {
		fileHelper.init();
		MUtil = new MnistUtil();
		String Modeljson = fileHelper.readFromDisk("files/Model.json");
		neuralnetwork.init(JsonHelper.JsonToClass(Modeljson, Layer[].class));
        int correct = 0;
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("    Genauigkeits Test");
		for (MnistImage mnistimg : MUtil.getImages((int) TESTNUMBER)) {
			if(neuralnetwork.recognitionNumber(StatUtil.ArrayListtoFloatArray(mnistimg.getImgdata())) == mnistimg.getLabel()) {
				correct = correct+1;
			}
		}
		System.out.println("");
		System.out.println("  =====================");
		System.out.println("   Genauigkeit: " + (correct/TESTNUMBER)*100 + "%");
		System.out.println("  =====================");
		System.out.println("");
		System.out.println("-------------------------");
	}
}
