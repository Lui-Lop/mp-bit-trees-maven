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
   *
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
    }
    if (ch == '0') {
      if (curr.left == null) {
        curr.left = new BitTreeNode();
      }
      return curr.left;
    } else if (ch == '1') {
      if (curr.right == null) {
        curr.right = new BitTreeNode();
      }
      return curr.right;
    }
    return curr;
  }

  public void treeVals (PrintWriter pen, BitTreeNode node, String str) {
    if (node.left != null) {
      treeVals(pen, node.left, str + "0");
    }
    if (node.right != null) {
      treeVals(pen, node.right, str + "1");
    }
    if (node.value != null) {
      pen.println(str + "," + get(str));
    }
  }
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   *
   */
  public void set(String bits, String value) {
    if (bits.length() != this.size) {
      throw new IndexOutOfBoundsException();
    }
    if (this.root == null) {
      this.root = new BitTreeNode();
    }
    BitTreeNode curr = this.root;
    char[] bitArr = bits.toCharArray();
    for (char ch : bitArr) {
      curr = nextNode(curr, ch);
    }
    curr.value = value;
  } // set(String, String)

  /**
   *
   */
  public String get(String bits) {
    if (bits.length() > size) {
      throw new IndexOutOfBoundsException();
    }
    BitTreeNode curr = this.root;
    char[] bitArr = bits.toCharArray();
    for (char ch : bitArr) {
      curr = nextNode(curr, ch);
    }
    return curr.value;
  } // get(String, String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    treeVals(pen, this.root, "");
  } // dump(PrintWriter)

  /**
   *
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
      }
    } catch (IOException e) {
      // Assuming formated correctly in file received
      e.printStackTrace();
    }
  } // load(InputStream)

} // class BitTree
