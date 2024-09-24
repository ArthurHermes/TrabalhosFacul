class Tree:
  def __init__(self, char='', left=None, right=None):
    self.char = char
    self.left = left
    self.right = right

def morse_to_char(morse_tree, sequence, i=0):
  if i == len(sequence):
    return morse_tree.char
  elif sequence[i] == '.':
    return morse_to_char(morse_tree.left, sequence, i+1)
  else:
    return morse_to_char(morse_tree.right, sequence, i+1)

def decode_morse(morse_tree, str):
  decoded = ''
  sequences = str.split(' ')
  for sequence in sequences:
    if sequence == '/':
      decoded += ' '
    else:
      decoded += morse_to_char(morse_tree, sequence)
  return decoded


morse_tree = Tree('',
                Tree('E',
                     Tree('I',
                          Tree('S',
                               Tree('H',
                                    Tree('5'),
                                    Tree('4')),
                               Tree('V',
                                    Tree(''),
                                    Tree('3'))),
                          Tree('U',
                               Tree('F',
                                    Tree(''),
                                    Tree('')),
                               Tree('',
                                    Tree(''),
                                    Tree('2')))),
                     Tree('A',
                          Tree('R',
                               Tree('L',
                                    Tree(''),
                                    Tree('')),
                               Tree('',
                                    Tree('+'),
                                    Tree(''))),
                          Tree('W',
                               Tree('P',
                                    Tree(''),
                                    Tree('')),
                               Tree('J',
                                    Tree(''),
                                    Tree('1'))))),
                Tree('T',
                     Tree('N',
                          Tree('D',
                               Tree('B',
                                    Tree('6'),
                                    Tree('=')),
                               Tree('X',
                                    Tree('/'),
                                    Tree(''))),
                          Tree('K',
                               Tree('C',
                                    Tree(''),
                                    Tree('')),
                               Tree('Y',
                                    Tree(''),
                                    Tree('')))),
                     Tree('M',
                          Tree('G',
                               Tree('Z',
                                    Tree('7'),
                                    Tree('')),
                               Tree('Q',
                                    Tree(''),
                                    Tree(''))),
                          Tree('O',
                               Tree('',
                                    Tree('8'),
                                    Tree('')),
                               Tree('',
                                    Tree('9'),
                                    Tree('0'))))))

print(decode_morse(morse_tree, '.. -. ... .. -.. . / -.-. --- -.. .'))