package StartClasses;

import java.io.IOException;
import java.util.ArrayList;

import NeuralNetwork.NeuralNetwork;
import NeuralNetwork.StatUtil;
import Utilis.FileHelper;
import Utilis.ImageHelper;
import Utilis.JsonHelper;
import lib.NeuralNetworkSave;

public class MainImage {
	
	private static NeuralNetwork neuralnetwork = new NeuralNetwork();
	
	public static FileHelper fileHelper = new FileHelper();
	
	public static void main(String[] args) throws IOException {
		fileHelper.init();
		String Modeljson = fileHelper.readFromDisk("files/Model.json");
		neuralnetwork.init(JsonHelper.JsonToClass(Modeljson, NeuralNetworkSave.class).getNETWORK());
		ArrayList<Float> ImageData = ImageHelper.getImageData("Image.jpeg");
		int KINumber = neuralnetwork.recognitionNumber(StatUtil.ArrayListtoFloatArray(ImageData));
		System.out.println("============");
        System.out.println("KI-Output: " + KINumber);
        System.out.println("============");
	}

}
