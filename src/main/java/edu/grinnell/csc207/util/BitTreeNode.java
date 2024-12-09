package edu.grinnell.csc207.util;

/**
 * An interface for different tyeps of nodes.
 */
public class BitTreeNode {

  /**
   * field for value in node.
   */
  String value;

  /**
   * field for left branch.
   */
  BitTreeNode left;

  /**
   * Field for right branch.
   */
  BitTreeNode right;

  /**
   * Constructs an empty node.
   */
  public BitTreeNode() {
    this.value = null;
    this.left = null;
    this.right = null;
  } // BitTreeNode()

  /**
   * Constructor of a new node with a value.
   *
   * @param str
   *            The value you want the node to have
   */
  public BitTreeNode(String str) {
    this.value = str;
  } // BitTreeNode (String)
} // BitTreeNode class
