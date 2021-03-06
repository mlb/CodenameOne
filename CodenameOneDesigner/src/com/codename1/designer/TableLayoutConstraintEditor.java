/*
 * Copyright (c) 2008, 2010, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores
 * CA 94065 USA or visit www.oracle.com if you need additional information or
 * have any questions.
 */

package com.codename1.designer;

import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Shai
 */
public class TableLayoutConstraintEditor extends javax.swing.JPanel {
    private static final int[] ALIGN = {-1, com.codename1.ui.Component.LEFT,
        com.codename1.ui.Component.CENTER, com.codename1.ui.Component.RIGHT};
    private static final int[] VALIGN = {-1, com.codename1.ui.Component.TOP,
        com.codename1.ui.Component.CENTER, com.codename1.ui.Component.BOTTOM};

    private com.codename1.ui.table.TableLayout l;

    /** Creates new form TableLayoutConstraintEditor */
    public TableLayoutConstraintEditor(com.codename1.ui.table.TableLayout l, com.codename1.ui.table.TableLayout.Constraint con) {
        this.l = l;
        initComponents();
        if(con == null) {
            row.setModel(new SpinnerNumberModel(-1, -1, 1000, 1));
            column.setModel(new SpinnerNumberModel(-1, -1, 1000, 1));
            width.setModel(new SpinnerNumberModel(-2, -1, 100, 1));
            height.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
            hspan.setModel(new SpinnerNumberModel(1, 1, 20, 1));
            vspan.setModel(new SpinnerNumberModel(1, 1, 20, 1));
        } else {
            row.setModel(new SpinnerNumberModel(con.getRow(), -1, l.getRows() - 1, 1));
            column.setModel(new SpinnerNumberModel(con.getColumn(), -1, l.getColumns() - 1, 1));
            width.setModel(new SpinnerNumberModel(con.getWidthPercentage(), -2, 100, 1));
            height.setModel(new SpinnerNumberModel(con.getHeightPercentage(), -1, 100, 1));
            hspan.setModel(new SpinnerNumberModel(con.getHorizontalSpan(), 1, 20, 1));
            vspan.setModel(new SpinnerNumberModel(con.getVerticalSpan(), 1, 20, 1));
            for(int iter = 0 ; iter < ALIGN.length ; iter++) {
                if(ALIGN[iter] == con.getHorizontalAlign()) {
                    align.setSelectedIndex(iter);
                    break;
                }
            }
            for(int iter = 0 ; iter < VALIGN.length ; iter++) {
                if(VALIGN[iter] == con.getVerticalAlign()) {
                    valign.setSelectedIndex(iter);
                    break;
                }
            }
        }
    }

    public com.codename1.ui.table.TableLayout.Constraint getResult() {
        com.codename1.ui.table.TableLayout.Constraint con = l.createConstraint(((Number)row.getValue()).intValue(), ((Number)column.getValue()).intValue());
        con.setWidthPercentage(((Number)width.getValue()).intValue());
        con.setHeightPercentage(((Number)height.getValue()).intValue());
        con.setHorizontalSpan(((Number)hspan.getValue()).intValue());
        con.setVerticalSpan(((Number)vspan.getValue()).intValue());
        con.setHorizontalAlign(ALIGN[align.getSelectedIndex()]);
        con.setVerticalAlign(VALIGN[valign.getSelectedIndex()]);
        return con;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        row = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        column = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        width = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        height = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        hspan = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        vspan = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        align = new javax.swing.JComboBox();
        valign = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        jLabel1.setText("Row");
        jLabel1.setName("jLabel1"); // NOI18N

        row.setName("row"); // NOI18N

        jLabel2.setText("Column");
        jLabel2.setName("jLabel2"); // NOI18N

        column.setName("column"); // NOI18N

        jLabel3.setText("Width %");
        jLabel3.setName("jLabel3"); // NOI18N

        width.setName("width"); // NOI18N

        jLabel4.setText("Height %");
        jLabel4.setName("jLabel4"); // NOI18N

        height.setName("height"); // NOI18N

        jLabel5.setText("Horizontal Span");
        jLabel5.setName("jLabel5"); // NOI18N

        hspan.setName("hspan"); // NOI18N

        jLabel6.setText("Vertical Span");
        jLabel6.setName("jLabel6"); // NOI18N

        vspan.setName("vspan"); // NOI18N

        jLabel7.setText("Align");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText("Vertical Align");
        jLabel8.setName("jLabel8"); // NOI18N

        align.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NONE", "LEFT", "CENTER", "RIGHT" }));
        align.setName("align"); // NOI18N

        valign.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NONE", "TOP", "CENTER", "BOTTOM" }));
        valign.setName("valign"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jEditorPane1.setContentType("text/html");
        jEditorPane1.setEditable(false);
        jEditorPane1.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n    <p style=\"margin-top: 0\">\r\n      \rAn entry within a table layout can be configured in various ways most of which are very similar\nto the familiar HTML table tag in part because this layout is used by the CodenameOne HTML component\nin order to implement the HTML table tag...<br>\nA cell can be positioned in an absolute row/column (to use the default set the value to -1). \nThe width/height of a cell (and thus its neighboring cells) can be determined as a percentage \nof the available space for the table. \n    </p>\r\n    <p>      \nCells can be spanned horizontally or vertically which causes a component to occupy several \ncells thus producing elaborate layout effects. Spanning defaults to 1 which means no spanning.\nIf a cell content is smaller than the cell itself it can be aligned horizontally or vertically, the\ndefault indicates that an entry should fill the cell bounds.\n    </p>\n  </body>\r\n</html>\r\n"); // NOI18N
        jEditorPane1.setName("jEditorPane1"); // NOI18N
        jScrollPane1.setViewportView(jEditorPane1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jLabel6)
                    .add(jLabel7)
                    .add(jLabel8))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(vspan, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(hspan, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(height, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(width, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(column, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(align, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(valign, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(row, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {align, column, height, hspan, row, valign, vspan, width}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(row, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(8, 8, 8)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(column, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(width, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(height, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(hspan, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel6)
                            .add(vspan, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(align, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel8)
                            .add(valign, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox align;
    private javax.swing.JSpinner column;
    private javax.swing.JSpinner height;
    private javax.swing.JSpinner hspan;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner row;
    private javax.swing.JComboBox valign;
    private javax.swing.JSpinner vspan;
    private javax.swing.JSpinner width;
    // End of variables declaration//GEN-END:variables

}
