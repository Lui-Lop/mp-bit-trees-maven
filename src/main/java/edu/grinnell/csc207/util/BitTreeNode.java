package edu.grinnell.csc207.util;
/**
 * An interface for different tyeps of nodes
 */
public class BitTreeNode {
    
    String value;

    BitTreeNode left;

    BitTreeNode right;

    public BitTreeNode () {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public BitTreeNode (String str) {
        this.value = str;
    }

    public void addLeft(BitTreeNode node) {
        this.left = node;
    }

    public void addRight(BitTreeNode node) {
        this.right = node;
    }

    public void setValue(String val) {
        this.value = val;
    }

    public String getValue() {
        return this.value;
    }
}
