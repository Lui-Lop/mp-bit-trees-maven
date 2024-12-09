package edu.grinnell.csc207.util;

/**
 * An interface for different tyeps of nodes
 */
public class BitTreeNode {

  /**
   * Fields
   */

  String value;

  BitTreeNode left;

  BitTreeNode right;

  /**
   * Constructors
   */
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
