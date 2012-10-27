
/*
JHeader, a Java library and tools for reading and editing EXIF headers.
Copyright (C) 2005 Matthew Baker

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

For further information, please contact Matthew Baker on msb@safe-mail.net.
Project home page: www.sourceforge.net/jheader
*/
package net.sourceforge.jheader.gui;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import net.sourceforge.jheader.*;

/**
 * A modal dialog for editing dates and times.
 */
public class DateTimeDialog extends JDialog
    implements ActionListener, WindowListener
{
    private JSpinner m_yearField;
    private JSpinner m_monField;
    private JSpinner m_dayField;
    private JSpinner m_hourField;
    private JSpinner m_minField;
    private JSpinner m_secField;
    
    private JButton m_okButton = new JButton("OK");
    private JButton m_cancelButton = new JButton("Cancel");

    private boolean m_okClicked = false;
    private Calendar m_cal = new GregorianCalendar();

    /**
     * Constructor.
     *
     * @param parent parent frame.
     * @param value calendar to edit.
     * @param title window title.
     */
    public DateTimeDialog(Frame parent, Calendar value, String title)
    {
	super(parent, title, true);
	setLocationRelativeTo(parent);
	init(value);
    }

    /**
     * Constructor.
     *
     * @param parent parent dialog.
     * @param value calendar to edit.
     * @param title window title.
     */
    public DateTimeDialog(Dialog parent, Calendar value, String title)
    {
	super(parent, title, true);
	setLocationRelativeTo(parent);
	init(value);
    }

    private void init(Calendar value)
    {
	addWindowListener(this);

	SpinnerNumberModel yearModel
	    = new SpinnerNumberModel(new Integer(value.get(Calendar.YEAR)),
				     null, null, new Integer(1));
	m_yearField = new JSpinner();
	m_yearField.setValue(new Integer(value.get(Calendar.YEAR)));
	SpinnerNumberModel monModel
	    = new SpinnerNumberModel(value.get(Calendar.MONTH)
				     -Calendar.JANUARY+1, 1, 12, 1);
	m_monField = new JSpinner(monModel);
	SpinnerNumberModel dayModel
	    = new SpinnerNumberModel(value.get(Calendar.DAY_OF_MONTH), 1, 31,
				     1);
	m_dayField = new JSpinner(dayModel);
	SpinnerNumberModel hourModel
	    = new SpinnerNumberModel(value.get(Calendar.HOUR_OF_DAY), 0, 23,
				     1);
	m_hourField = new JSpinner(hourModel);
	SpinnerNumberModel minModel
	    = new SpinnerNumberModel(value.get(Calendar.MINUTE), 0, 59,
				     1);
	m_minField = new JSpinner(minModel);
	SpinnerNumberModel secModel
	    = new SpinnerNumberModel(value.get(Calendar.SECOND), 0, 59,
				     1);
	m_secField = new JSpinner(secModel);

	m_yearField.setEditor(new JSpinner.NumberEditor(m_yearField, "0000"));
	m_monField.setEditor(new JSpinner.NumberEditor(m_monField, "00"));
	m_dayField.setEditor(new JSpinner.NumberEditor(m_dayField, "00"));
	m_hourField.setEditor(new JSpinner.NumberEditor(m_hourField, "00"));
	m_minField.setEditor(new JSpinner.NumberEditor(m_minField, "00"));
	m_secField.setEditor(new JSpinner.NumberEditor(m_secField, "00"));
	
	GridBagLayout layout = new GridBagLayout();
	JPanel panel = new JPanel(layout);
	getContentPane().add(BorderLayout.CENTER, panel);
	panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

	GridBagConstraints constraints = new GridBagConstraints();
	constraints.anchor = GridBagConstraints.WEST;
	constraints.ipadx = 0;
	constraints.ipady = 0;
	constraints.weighty = 0.0;
	constraints.gridheight = 1;
	constraints.insets = new Insets(5,5,5,5);
	
	// date label
	JLabel dateLabel = new JLabel("Date");
	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 6;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(dateLabel, constraints);
	panel.add(dateLabel);
	
	// year label
	JLabel yearLabel = new JLabel("Year");
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(yearLabel, constraints);
	panel.add(yearLabel);
	
	// year field
	constraints.gridx = 1;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(m_yearField, constraints);
	panel.add(m_yearField);
	
	// mon label
	JLabel monLabel = new JLabel("Month");
	constraints.gridx = 2;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(monLabel, constraints);
	panel.add(monLabel);
	
	// mon field
	constraints.gridx = 3;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(m_monField, constraints);
	panel.add(m_monField);
	
	// day label
	JLabel dayLabel = new JLabel("Day");
	constraints.gridx = 4;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(dayLabel, constraints);
	panel.add(dayLabel);
	
	// day field
	constraints.gridx = 5;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(m_dayField, constraints);
	panel.add(m_dayField);
	
	// time label
	JLabel timeLabel = new JLabel("Time");
	constraints.gridx = 0;
	constraints.gridy = 2;
	constraints.gridwidth = 6;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(timeLabel, constraints);
	panel.add(timeLabel);
	
	// hour label
	JLabel hourLabel = new JLabel("Hour");
	constraints.gridx = 0;
	constraints.gridy = 3;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(hourLabel, constraints);
	panel.add(hourLabel);
	
	// hour field
	constraints.gridx = 1;
	constraints.gridy = 3;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(m_hourField, constraints);
	panel.add(m_hourField);
	
	// min label
	JLabel minLabel = new JLabel("Min");
	constraints.gridx = 2;
	constraints.gridy = 3;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(minLabel, constraints);
	panel.add(minLabel);
	
	// min field
	constraints.gridx = 3;
	constraints.gridy = 3;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(m_minField, constraints);
	panel.add(m_minField);
	
	// sec label
	JLabel secLabel = new JLabel("Sec");
	constraints.gridx = 4;
	constraints.gridy = 3;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(secLabel, constraints);
	panel.add(secLabel);
	
	// sec field
	constraints.gridx = 5;
	constraints.gridy = 3;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(m_secField, constraints);
	panel.add(m_secField);
	
	// ok and close buttons
	JPanel buttonPanel = new JPanel(new FlowLayout());
	getContentPane().add(BorderLayout.SOUTH, buttonPanel);
	buttonPanel.add(m_okButton);
	buttonPanel.add(m_cancelButton);
	m_okButton.addActionListener(this);
	m_cancelButton.addActionListener(this);
	
	pack();
    }

    /**
     * Opens the dialog modally and, if OK is closed, sets the date/time
     * in the Calendar that was passed to the constructor.
     *
     * @return true if OK was clicked (and the calendar was updated), false
     * if Cancel was clicked (and the calendar was untouched).
     */
    public boolean getResponse()
    {
	setVisible(true);
	m_cal.set(Calendar.YEAR,
		  ((SpinnerNumberModel)m_yearField.getModel()).getNumber().intValue());
	m_cal.set(Calendar.MONTH,
		  ((SpinnerNumberModel)m_monField.getModel()).getNumber().intValue()-1
		  +Calendar.JANUARY);
	m_cal.set(Calendar.DAY_OF_MONTH,
		  ((SpinnerNumberModel)m_dayField.getModel()).getNumber().intValue());
	m_cal.set(Calendar.HOUR_OF_DAY,
		  ((SpinnerNumberModel)m_hourField.getModel()).getNumber().intValue());
	m_cal.set(Calendar.MINUTE,
		  ((SpinnerNumberModel)m_minField.getModel()).getNumber().intValue());
	m_cal.set(Calendar.SECOND,
		  ((SpinnerNumberModel)m_secField.getModel()).getNumber().intValue());
	return m_okClicked;
    }

    /**
     * Return the Calendar object that was passed to the constructor.
     */
    public Calendar getCalendar()
    {
	return m_cal;
    }

    /////////////////////////////////////////////////////////////////////
    // ActionListener methods
    
    public void actionPerformed(ActionEvent evt)
    {
	if (evt.getSource() == m_cancelButton) dispose();
	else if (evt.getSource() == m_okButton)
	{
	    m_okClicked = true;
	    dispose();
	}
    }
  
    /////////////////////////////////////////////////////////////////////
    // WindowListener methods
    
    public void windowClosing(WindowEvent e)
    {
	dispose();
    }

    public void windowClosed(WindowEvent e) {}
    
    public void windowOpened(WindowEvent e) {}
    
    public void windowIconified(WindowEvent e) {}
    
    public void windowDeiconified(WindowEvent e) {}
    
    public void windowActivated(WindowEvent e) {}
    
    public void windowDeactivated(WindowEvent e) {}
}
