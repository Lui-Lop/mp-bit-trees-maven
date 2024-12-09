package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length 
 * sequences of bits and corresponding values.
 *
 * @author Luis Lopez
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  int size;

  BitTreeNode root;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Sets the size of the bit tree.
   * @param n
   *  The size you want the bit tree to be
   */
  public BitTree(int n) {
    this.size = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  public BitTreeNode nextNode(BitTreeNode curr, char ch) {
    if (!Character.isDigit(ch)) {
      throw new IndexOutOfBoundsException();
    } // if
    if (ch == '0') {
      if (curr.left == null) {
        curr.left = new BitTreeNode();
      } // if
      return curr.left;
    } else if (ch == '1') {
      if (curr.right == null) {
        curr.right = new BitTreeNode();
      } // if
      return curr.right;
    } // if
    return curr;
  } // nextNode(BitTreeNode, char)


  /**
   * Goes through a tree to reach leaves and print values.
   * @param pen
   *  where the values should be printed
   * @param node
   *  the previous node that has been found
   * @param str
   *  the current string for each branch gone down
   */
  public void treeVals (PrintWriter pen, BitTreeNode node, String str) {
    if (node.left != null) {
      treeVals(pen, node.left, str + "0");
    } // if
    if (node.right != null) {
      treeVals(pen, node.right, str + "1");
    } // if
    if (node.value != null) {
      pen.println(str + "," + get(str));
    } // if
  }// treeVals (PrintWriter, BitTreeNode, String)
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

/**
 * Sets a value based on the bit string for it, sets a new node when needed
 * @param bits
 *  bit string that is meant to represent a value
 * @param value
 *  a value that you want to be set into tree
 */
  public void set(String bits, String value) {
    if (bits.length() != this.size) {
      throw new IndexOutOfBoundsException();
    } // if
    if (this.root == null) {
      this.root = new BitTreeNode();
    } // if
    BitTreeNode curr = this.root;
    char[] bitArr = bits.toCharArray();
    for (char ch : bitArr) {
      curr = nextNode(curr, ch);
    } // for
    curr.value = value;
  } // set(String, String)

/**
 * Gets a value from tree based on bit string
 * @param bits
 *  bit string to go through tree
 * @return
 *  string value from tree
 */
  public String get(String bits) {
    if (bits.length() > size) {
      throw new IndexOutOfBoundsException();
    } // if
    BitTreeNode curr = this.root;
    char[] bitArr = bits.toCharArray();
    for (char ch : bitArr) {
      curr = nextNode(curr, ch);
    } // for
    return curr.value;
  } // get(String, String)

/**
 * Prints out all the contents
 * @param pen
 *  the printwriter you wish to print to
 */
  public void dump(PrintWriter pen) {
    treeVals(pen, this.root, "");
  } // dump(PrintWriter)

/**
 * Takes an input that can be multiple sets of values
 * that you want to put into a tree
 * @param source
 *  the InputStream with the values you want to set
 */
  public void load(InputStream source) {
    InputStreamReader strmRead = new InputStreamReader(source);
    BufferedReader reader = new BufferedReader(strmRead);
    String line;
    try {
      line = reader.readLine();
      while (line != null) {
        String[] inputs = line.split(",");
        set(inputs[0], inputs[1]);
        line = reader.readLine();
      } // while
    } catch (IOException e) {
      // Assuming formated correctly in file received
      e.printStackTrace();
    } // try/catch
  } // load(InputStream)

} // class BitTree
