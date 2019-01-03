package deepnetts.examples;

import deepnetts.core.DeepNetts;
import deepnetts.data.ImageSet;
import deepnetts.eval.ClassifierEvaluator;
import deepnetts.eval.PerformanceMeasure;
import deepnetts.net.ConvolutionalNetwork;
import deepnetts.net.layers.activation.ActivationType;
import deepnetts.net.loss.LossType;
import deepnetts.net.train.BackpropagationTrainer;
import deepnetts.net.train.opt.OptimizerType;
import deepnetts.util.DeepNettsException;
import deepnetts.util.FileIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunLegoPeople {
            
    int imageWidth = 96;
    int imageHeight = 96;

    String trainingFile = "D:\\datasets\\LegoPeopleNoviJecaPreprocessed\\train.txt";     
    String labelsFile = "D:\\datasets\\LegoPeopleNoviJecaPreprocessed\\labels.txt";
    
//    String labelsFile = "/home/zoran/datasets/LegoPeopleNoviJecaPreprocessed/labels.txt";
//    String trainingFile = "/home/zoran/datasets/LegoPeopleNoviJecaPreprocessed/train.txt";    
         
    
    static final Logger LOG = Logger.getLogger(DeepNetts.class.getName());
    
    
    public void run() throws DeepNettsException, IOException {
     
        ImageSet imageSet = new ImageSet(imageWidth, imageHeight);
       
        LOG.info("Loading images...");
        
        imageSet.loadLabels(new File(labelsFile));
        imageSet.loadImages(new File(trainingFile), true);
        imageSet.invert();
        imageSet.zeroMean();
        imageSet.shuffle();
            
        ImageSet[] imageSets = imageSet.split(0.66, 0.34);
        
        LOG.info("Done loading images.");             
                
        // create convolutional neural network
        LOG.info("Creating neural network...");

        ConvolutionalNetwork legoPeopleNet = new ConvolutionalNetwork.Builder()
                                        .addInputLayer(imageWidth, imageHeight, 3) 
                                        .addConvolutionalLayer(5, 5, 1) 
                                        .addMaxPoolingLayer(2, 2, 2)                                  
                                        .addDenseLayer(30, ActivationType.TANH)  
                                        .addDenseLayer(10, ActivationType.TANH)  
                                        .addOutputLayer(1, ActivationType.SIGMOID)
                                        .lossFunction(LossType.CROSS_ENTROPY)                
                                        .withRandomSeed(123)
                                        .build();        
              
        LOG.info("Done creating network.");       
        LOG.info("Training neural network..."); 
        
        legoPeopleNet.setOutputLabels(imageSet.getOutputLabels());  
      //  List<ImageSet> subsets = imageSet.split(20, 80);
        
        // train convolutional network
        BackpropagationTrainer trainer = new BackpropagationTrainer();
        trainer.setLearningRate(0.01f);
       // trainer.setMomentum(0.1f);
        trainer.setMaxError(0.06f);
        trainer.setOptimizer(OptimizerType.SGD);
        trainer.setBatchMode(true).setBatchSize(10);
        trainer.train(legoPeopleNet, imageSets[0]);   
        
        LOG.info("Done training neural network."); 
          
        // save  network
        try {
            FileIO.writeToFile(legoPeopleNet, "legoPeople.net");
        } catch (IOException ex) {
            Logger.getLogger(RunLegoPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // deserialize and evaluate neural network
        ConvolutionalNetwork legoNet=null;
   //     try {
     //       legoNet = (ConvolutionalNetwork) FileIO.createFromFile("legoPeople.net");            
        ClassifierEvaluator evaluator = new ClassifierEvaluator();
        PerformanceMeasure  pm =  evaluator.evaluatePerformance(legoPeopleNet, imageSets[1]);
        System.out.println(pm);
                    
//        } catch (IOException | ClassNotFoundException ex) {
//            Logger.getLogger(RunLegoPeople.class.getName()).log(Level.SEVERE, null, ex);
//        }
                           
//        ImageRecognizer imageRecognizer = new DeepNettsImageRecognizer(legoPeopleNet);
//        List<RecognitionResult> results = imageRecognizer.recognize(new File("/home/zoran/datasets/LegoPeople/negative/bg1.jpg"));
//        System.out.println(results.toString());                       
    }
    
    
    
    
    public static void main(String[] args) {                                 
        try {
            (new RunLegoPeople()).run();
        } catch (DeepNettsException | IOException ex) {
            Logger.getLogger(RunLegoPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
   
                
    }
}