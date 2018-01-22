/**  
 *  DeepNetts is pure Java Deep Learning Library with support for Backpropagation 
 *  based learning and image recognition.
 * 
 *  Copyright (C) 2017  Zoran Sevarac <sevarac@gmail.com>
 *
 *  This file is part of DeepNetts.
 *
 *  DeepNetts is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.package deepnetts.core;
 */
    
package deepnetts.examples;

import deepnetts.data.DataSet;
import deepnetts.eval.ConvolutionalClassifierEvaluator;
import deepnetts.eval.FeedForwardClassifierEvaluator;
import deepnetts.net.FeedForwardNetwork;
import deepnetts.net.layers.ActivationType;
import deepnetts.net.loss.LossType;
import deepnetts.net.train.BackpropagationTrainer;
import deepnetts.util.DeepNettsException;
import java.io.File;
import java.io.IOException;

/**
 * Iris Classification Problem.
 * This example is using Softmax activation in output addLayer and Cross Entropy Loss function.
 * 
 * @author Zoran Sevarac <zoran.sevarac@smart4net.co>
 */
public class IrisClassificationCE2 {
    
    public static void main(String[] args) throws DeepNettsException, IOException {
        
        // load iris data  set
        DataSet dataSet = DataSet.fromCSVFile(new File("datasets/iris_data_normalised.txt"), 4, 3, ",");        
        // shiffle the data set to randomize the order - shuffle during the training?
        dataSet.shuffle();
        DataSet[] dataSets = dataSet.split(65, 35);// verify params
        
        // create instance of multi addLayer percetpron using builder
        FeedForwardNetwork neuralNet = FeedForwardNetwork.builder()
                                            .addInputLayer(4)
                                            .addFullyConnectedLayer(3, ActivationType.TANH)
//                                          .addFullyConnectedLayer(3, ActivationType.TANH)
                                            .addOutputLayer(3, ActivationType.SOFTMAX)
                                            .withLossFunction(LossType.CROSS_ENTROPY)
                                            .withRandomSeed(123).
                                        build();
              
        // create and configure instanceof backpropagation trainer 
        BackpropagationTrainer trainer = new BackpropagationTrainer(neuralNet);
        trainer.setMaxError(0.03f);
        trainer.setLearningRate(0.1f);
        trainer.setMomentum(0.3f);
        trainer.setBatchMode(false);
        //trainer.setBatchSize(150);
        trainer.setMaxEpochs(10000);
        trainer.train(dataSets[0]);                                                                                                                
        
        
        FeedForwardClassifierEvaluator tester = new FeedForwardClassifierEvaluator();
        tester.evaluate(neuralNet, dataSets[1]);     
        System.out.println(tester);              
        
    }
    
}
