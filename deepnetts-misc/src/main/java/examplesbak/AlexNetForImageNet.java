/**
 *  DeepNetts is pure Java Deep Learning Library with support for Backpropagation
 *  based learning and image recognition.
 *
 *  Copyright (C) 2017  Zoran Sevarac <sevarac@gmail.com>
 *
 * This file is part of DeepNetts.
 *
 * DeepNetts is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <https://www.gnu.org/licenses/>.package
 * deepnetts.core;
 */
package examplesbak;

import deepnetts.core.DeepNetts;
import deepnetts.data.ImageSet;
import deepnetts.net.ConvolutionalNetwork;
import deepnetts.net.layers.activation.ActivationType;
import deepnetts.net.train.BackpropagationTrainer;
import deepnetts.util.DeepNettsException;
import deepnetts.eval.ClassifierEvaluator;
import deepnetts.net.loss.LossType;
import deepnetts.net.train.opt.OptimizerType;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.visrec.ml.eval.EvaluationMetrics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlexNetForImageNet {

    int imageWidth = 32;
    int imageHeight = 32;

    //String labelsFile = "/home/zoran/datasets/cifar10/train/labels.txt";
    String labelsFile = "D:\\datasets\\cifar10\\train\\labels.txt";
    //String trainingFile = "datasets/cifar10/train.txt";
    //String trainingFile = "/home/zoran/datasets/cifar10/train/train.txt";
    String trainingFile = "D:\\datasets\\cifar10\\train\\index.txt";
    // String testFile = "datasets/cifar10/test.txt";

    static final Logger LOGGER = LogManager.getLogger(DeepNetts.class.getName());

    public void run() throws DeepNettsException, IOException {
        LOGGER.info("Loading images...");
        ImageSet imageSet = new ImageSet(imageWidth, imageHeight);
        imageSet.loadLabels(new File(labelsFile));
        imageSet.loadImages(new File(trainingFile), 1000);
//        imageSet.invert();
        imageSet.zeroMean();
        imageSet.shuffle();

        int labelsCount = imageSet.getLabelsCount();

        ImageSet[] imageSets = imageSet.split(0.66, 0.34);

        LOGGER.info("Creating neural network...");

        // input treba da bude 224 x224 za 1000 klasa
        ConvolutionalNetwork neuralNet = ConvolutionalNetwork.builder()
                .addInputLayer(imageWidth, imageHeight)
                .addConvolutionalLayer(11, 11, 96) // 11 x 11
                .addMaxPoolingLayer(2, 2, 2) // 3, 3, 2
                .addConvolutionalLayer(5, 5, 256)
                .addMaxPoolingLayer(2, 2, 2)
                .addConvolutionalLayer(3, 3, 384)
                .addConvolutionalLayer(3, 3, 384)
                .addConvolutionalLayer(3, 3, 256)
                .addFullyConnectedLayer(4096)
                .addFullyConnectedLayer(4096)
                .addOutputLayer(labelsCount, ActivationType.SOFTMAX)
                .hiddenActivationFunction(ActivationType.RELU)
                .lossFunction(LossType.CROSS_ENTROPY)
                .build();

        LOGGER.info("Training neural network");

        BackpropagationTrainer trainer = new BackpropagationTrainer(neuralNet);
        trainer.setLearningRate(0.01f);
        trainer.setMaxError(0.1f);
        trainer.setMomentum(0.7f);
               // .setBatchMode(true)
          //      .setBatchSize(128);
        trainer.setOptimizer(OptimizerType.MOMENTUM);
        trainer.train(imageSets[0]);

        // Test trained network
        ClassifierEvaluator evaluator = new ClassifierEvaluator();
        EvaluationMetrics pm = evaluator.evaluate(neuralNet, imageSets[1]);
        LOGGER.info("------------------------------------------------");
        LOGGER.info("Classification performance measure" + System.lineSeparator());
        LOGGER.info("TOTAL AVERAGE");
        LOGGER.info(evaluator.getTotalAverage());
        LOGGER.info("By Class");
        Map<String, EvaluationMetrics> byClass = evaluator.getPerformanceByClass();
        byClass.entrySet().stream().forEach((entry) -> {
            LOGGER.info("Class " + entry.getKey() + ":");
            LOGGER.info(entry.getValue());
            LOGGER.info("----------------");
        });

    }

    public static void main(String[] args) throws DeepNettsException, IOException {
        (new AlexNetForImageNet()).run();
    }
}
