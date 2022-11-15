import MNISTUtilis.MnistImage;
import MNISTUtilis.MnistUtil;
import NeuralNetwork.Layer;
import NeuralNetwork.NeuralNetwork;
import NeuralNetwork.StatUtil;
import Utilis.FileHelper;
import Utilis.JsonHelper;

public class TestNetwork {
    private static NeuralNetwork neuralnetwork = new NeuralNetwork();
	
	public static FileHelper fileHelper = new FileHelper();
	
	public static MnistUtil MUtil;
	
	public static void main(String[] args) throws IOException {
		fileHelper.init();
		MUtil = new MnistUtil();
		String Modeljson = fileHelper.readFromDisk("files/Model.json");
		neuralnetwork.init(JsonHelper.JsonToClass(Modeljson, Layer[].class));
        int correct = 0;
		for (MnistImage mnistimg : MUtil.getImages(100)) {
            if((neuralnetwork.recognitionNumber(StatUtil.ArrayListtoFloatArray(mnistimg.getImgdata()))+"") == (mnistimg.getLabel()+"")) {
                correct += 1;
            }
		}
		System.out.println("Genauigkeit: " + (correct/100)*100);
	}
}
