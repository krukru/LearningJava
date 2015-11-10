package kru.honi.round2;

import java.util.Scanner;

public class Gepetto {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfIngredients = scanner.nextInt();
    int numberOfForbiddenCombinations = scanner.nextInt();
    BitSuffixTree bst = new BitSuffixTree();
    for (int i = 0; i < numberOfForbiddenCombinations; i++) {
      int firstIngredient = scanner.nextInt();
      int secondIngredient = scanner.nextInt();
      int ingredientMask = (1 << (firstIngredient - 1)) | (1 << (secondIngredient - 1));
      bst.addNumber(ingredientMask);
    }
    int result = numberOfPossibleCombinations(numberOfIngredients, bst);
    System.out.println(result);
  }

  public static int numberOfPossibleCombinations(int numberOfIngredients, BitSuffixTree bst) {
    //check if tree is empty
    int numberOfPossibleCombinations = (1 << numberOfIngredients);
    int numberOfValidCombinations = 0;
    for (int i = 0; i < numberOfPossibleCombinations; i++) {
      if (bst.hasMatch(i) == false) {
        numberOfValidCombinations += 1;
      }
    }
    return numberOfValidCombinations;
  }


}

class BitSuffixTree {

  public BinaryTreeNode root = new BinaryTreeNode();

  public boolean internalHashMatch(BinaryTreeNode currentNode, int number) {
    if (currentNode == null) {
      return false;
    }
    if (currentNode.data != null) {
      return true;
    }
    if (number == 0) {
      return false;
    }
    int rightMostBit = number & 1;
    number = number >> 1;
    if (rightMostBit == 0) {
      return internalHashMatch(currentNode.leftChild, number);
    } else {
      return internalHashMatch(currentNode.leftChild, number) || internalHashMatch(currentNode
          .rightChild, number);
    }
  }

  public boolean hasMatch(int number) {
    return internalHashMatch(root, number);
  }

  public void addNumber(int number) {
    //assert(number >= 0);
    int numberCopy = number;
    BinaryTreeNode currentNode = root;
    while (number > 0) {
      int rightMostBit = number & 1;
      number = number >> 1;
      if (rightMostBit == 0) {
        if (currentNode.leftChild == null) {
          currentNode.leftChild = new BinaryTreeNode();
        }
        currentNode = currentNode.leftChild;
      } else {
        if (currentNode.rightChild == null) {
          currentNode.rightChild = new BinaryTreeNode();
        }
        currentNode = currentNode.rightChild;
      }
    }
    currentNode.data = numberCopy;
  }

  private class BinaryTreeNode {

    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
    public Integer data;

  }

}
