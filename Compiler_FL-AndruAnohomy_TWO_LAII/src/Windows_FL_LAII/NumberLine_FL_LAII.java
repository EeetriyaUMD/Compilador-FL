package Windows_FL_LAII;

/**
 *
 * @author FL-AndruAnnohomy
 */
import java.awt.*;
import java.beans.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.*;

/**
 *
 * @author FL-AndruAnnohomy
 */
public class NumberLine_FL_LAII extends JPanel implements CaretListener, DocumentListener, PropertyChangeListener {

    private static final Logger LOG = Logger.getLogger(NumberLine_FL_LAII.class.getName());
    private static final long serialVersionUID = 2012201552509953L;

    /**
     *
     */
    public final static float LEFT = 0.0f;

    /**
     *
     */
    public final static float CENTER = 0.5f;

    /**
     *
     */
    public final static float RIGHT = 1.0f;

    private final static Border OUTER = new MatteBorder(0, 0, 0, 0, Color.BLACK);

    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    private final static int HEIGHT = Integer.MAX_VALUE - 1000000;

    private JTextComponent component;

    private boolean updateFont;
    private int borderGap;
    private Color currentLineForeground;
    private float digitAlignment;
    private int minimumDisplayDigits;

    private int lastDigits;
    private int lastHeight;
    private int lastLine;

    private HashMap<String, FontMetrics> fonts;

    /**
     *
     * @param component
     */
    public NumberLine_FL_LAII(JTextComponent component) {

        this(component, 3);

    }

    /**
     *
     * @param component
     * @param minimumDisplayDigits
     */
    @SuppressWarnings({"OverridableMethodCallInConstructor", "LeakingThisInConstructor"})
    public NumberLine_FL_LAII(JTextComponent component, int minimumDisplayDigits) {

        this.component = component;

        setFont(component.getFont());

        setCurrentLineForeground(Color.GRAY);
        setDigitAlignment(RIGHT);
        setMinimumDisplayDigits(minimumDisplayDigits);

        component.getDocument().addDocumentListener(this);
        component.addCaretListener(this);

    }

    /**
     *
     * @return
     */
    public boolean getUpdateFont() {

        return updateFont;

    }

    /**
     *
     * @param updateFont
     */
    public void setUpdateFont(boolean updateFont) {

        this.updateFont = updateFont;

    }

    /**
     *
     * @return
     */
    public int getBorderGap() {

        return borderGap;

    }

    /**
     *
     * @param borderGap
     */
    public void setBorderGap(int borderGap) {

        this.borderGap = borderGap;
        Border inner = new EmptyBorder(0, borderGap, 0, borderGap);
        setBorder(new CompoundBorder(OUTER, inner));
        lastDigits = 0;
        setPreferredWidth();

    }

    /**
     *
     * @return
     */
    public Color getCurrentLineForeground() {

        return currentLineForeground == null ? getForeground() : currentLineForeground;

    }

    /**
     *
     * @param currentLineForeground
     */
    public void setCurrentLineForeground(Color currentLineForeground) {

        this.currentLineForeground = currentLineForeground;

    }

    /**
     *
     * @return
     */
    public float getDigitAlignment() {

        return digitAlignment;

    }

    /**
     *
     * @param digitAlignment
     */
    public void setDigitAlignment(float digitAlignment) {

        this.digitAlignment = digitAlignment > 1.0f ? 1.0f : digitAlignment < 0.0f ? -1.0f : digitAlignment;

    }

    /**
     *
     * @return
     */
    public int getMinimumDisplayDigits() {

        return minimumDisplayDigits;

    }

    /**
     *
     * @param minimumDisplayDigits
     */
    public void setMinimumDisplayDigits(int minimumDisplayDigits) {

        this.minimumDisplayDigits = minimumDisplayDigits;
        setPreferredWidth();

    }

    private void setPreferredWidth() {

        Element root = component.getDocument().getDefaultRootElement();
        int lines = root.getElementCount();
        int digits = Math.max(String.valueOf(lines).length(), minimumDisplayDigits);

        if (lastDigits != digits) {

            lastDigits = digits;
            FontMetrics fontMetrics = getFontMetrics(getFont());
            int width = fontMetrics.charWidth('0') * digits;
            Insets insets = getInsets();
            int preferredWidth = insets.left + insets.right + width;

            Dimension d = getPreferredSize();
            d.setSize(preferredWidth, HEIGHT);
            setPreferredSize(d);
            setSize(d);

        }

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        FontMetrics fontMetrics = component.getFontMetrics(component.getFont());
        Insets insets = getInsets();
        int availableWidth = getSize().width - insets.left - insets.right;

        Rectangle clip = g.getClipBounds();
        int rowStartOffset = component.viewToModel(new Point(0, clip.y));
        int endOffset = component.viewToModel(new Point(0, clip.y + clip.height));

        while (rowStartOffset <= endOffset) {

            try {

                if (isCurrentLine(rowStartOffset)) {

                    g.setColor(getCurrentLineForeground());

                } else {

                    g.setColor(getForeground());

                }

                String lineNumber = getTextLineNumber(rowStartOffset);
                int stringWidth = fontMetrics.stringWidth(lineNumber);
                int x = getOffsetX(availableWidth, stringWidth) + insets.left;
                int y = getOffsetY(rowStartOffset, fontMetrics);
                g.drawString(lineNumber, x, y);

                rowStartOffset = Utilities.getRowEnd(component, rowStartOffset) + 1;

            } catch (Exception e) {

                Logger.getLogger(NumberLine_FL_LAII.class.getName()).log(Level.SEVERE, "Error");

            }

        }

    }

    private boolean isCurrentLine(int rowStartOffset) {

        int caretPosition = component.getCaretPosition();
        Element root = component.getDocument().getDefaultRootElement();
        return root.getElementIndex(rowStartOffset) == root.getElementIndex(caretPosition);

    }

    /**
     *
     * @param rowStartOffset
     * @return
     */
    protected String getTextLineNumber(int rowStartOffset) {

        Element root = component.getDocument().getDefaultRootElement();
        int index = root.getElementIndex(rowStartOffset);
        Element line = root.getElement(index);

        if (line.getStartOffset() == rowStartOffset) {

            return String.valueOf(index + 1);

        } else {

            return "";

        }

    }

    private int getOffsetX(int availableWidth, int stringWidth) {

        return (int) ((availableWidth - stringWidth) * digitAlignment);

    }

    @SuppressWarnings("Convert2Diamond")
    private int getOffsetY(int rowStartOffset, FontMetrics fontMetrics) throws BadLocationException {

        Rectangle r = component.modelToView(rowStartOffset);
        int lineHeight = fontMetrics.getHeight();
        int y = r.y + r.height;
        int descent = 0;

        if (r.height == lineHeight) {

            descent = fontMetrics.getDescent();

        } else {

            if (fonts == null) {

                fonts = new HashMap<String, FontMetrics>();

            }

            Element root = component.getDocument().getDefaultRootElement();
            int index = root.getElementIndex(rowStartOffset);
            Element line = root.getElement(index);

            for (int i = 0; i < line.getElementCount(); i++) {

                Element child = line.getElement(i);
                AttributeSet as = child.getAttributes();
                String fontFamily = (String) as.getAttribute(StyleConstants.FontFamily);
                Integer fontSize = (Integer) as.getAttribute(StyleConstants.FontSize);
                String key = fontFamily + fontSize;

                FontMetrics fm = fonts.get(key);

                if (fm == null) {

                    Font font = new Font(fontFamily, Font.PLAIN, fontSize);
                    fm = component.getFontMetrics(font);
                    fonts.put(key, fm);

                }

                descent = Math.max(descent, fm.getDescent());

            }

        }

        return y - descent;

    }

    @Override
    public void caretUpdate(CaretEvent e) {

        int caretPosition = component.getCaretPosition();
        Element root = component.getDocument().getDefaultRootElement();
        int currentLine = root.getElementIndex(caretPosition);

        if (lastLine != currentLine) {

            repaint();
            lastLine = currentLine;

        }

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

        documentChanged();

    }

    @Override
    public void insertUpdate(DocumentEvent e) {

        documentChanged();

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

        documentChanged();

    }

    private void documentChanged() {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                int preferredHeight = component.getPreferredSize().height;

                if (lastHeight != preferredHeight) {

                    setPreferredWidth();
                    repaint();
                    lastHeight = preferredHeight;

                }

            }

        });

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getNewValue() instanceof Font) {

            if (updateFont) {

                Font newFont = (Font) evt.getNewValue();
                setFont(newFont);
                lastDigits = 0;
                setPreferredWidth();

            } else {

                repaint();

            }

        }

    }

    @Override
    public String toString() {

        return "Created by FL- AndruAnnohomy smart pataforma: NumberLine_FL_LAII{" + '}';

    }

}
