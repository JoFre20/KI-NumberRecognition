package StartClasses;
import java.io.IOException;

import MNISTUtilis.MnistImage;
import MNISTUtilis.MnistUtil;
import NeuralNetwork.NeuralNetwork;
import NeuralNetwork.StatUtil;
import Utilis.FileHelper;
import Utilis.JsonHelper;
import lib.NeuralNetworkSave;

public class Main {
	
	//TODO: Add Class witch can Generate a Picture out of the PixelArray
	
	private static NeuralNetwork neuralnetwork = new NeuralNetwork();
	
	public static FileHelper fileHelper = new FileHelper();
	
	public static MnistUtil MUtil;
	
	public static void main(String[] args) throws IOException {
		fileHelper.init();
		MUtil = new MnistUtil();
		String Modeljson = fileHelper.readFromDisk("files/Model.json");
		neuralnetwork.init(JsonHelper.JsonToClass(Modeljson, NeuralNetworkSave.class).getNETWORK());
		for (MnistImage mnistimg : MUtil.getImages(1)) {
			System.out.println("============");
            System.out.println("KI-Output: " + neuralnetwork.recognitionNumber(StatUtil.ArrayListtoFloatArray(mnistimg.getImgdata())));
            System.out.println("Ex-Output: " + mnistimg.getLabel());
            System.out.println("============");
           
		}
		System.out.println("");
	}
	
	public static FileHelper getFileHelper() {
		return fileHelper;
	}

}
