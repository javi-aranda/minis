import numpy
import matplotlib.pyplot as plt
from sklearn import metrics


# Generate random data
actual = numpy.random.binomial(1, 0.9, size=1000) 
predicted = numpy.random.binomial(1, 0.9, size=1000)

# Create confusion matrix
confusion_matrix = metrics.confusion_matrix(actual, predicted)

# Display beautifully
cm_display = metrics.ConfusionMatrixDisplay(confusion_matrix = confusion_matrix, display_labels = [False, True])

# Show with Matplotlib
cm_display.plot() 
plt.show() 
