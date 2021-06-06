def find_str(s, char):
    index = 0

    if char in s:
        c = char[0]
        for ch in s:
            if ch == c:
                if s[index:index+len(char)] == char:
                    return index

            index += 1

    return -1

def end_codon(gene_code, codon):
    index = 0
    pos = gene_code.find(codon[0])
    end_codon = codon[0]

    for end in codon:
        if end in gene_code and gene_code.find(end) < pos and gene_code.find(end) %3 == 0:
            end_codon = end

    
    if end_codon in gene_code:
        c = end_codon[0]
        for ch in gene_code:
            if ch == c:
                if gene_code[index:index+len(end_codon)] == end_codon:
                    return index + 3

            index += 1

    return -1
print(find_str("acaatggtccctattagtgggcggcggcccgtataaact", "atg"))
print(end_codon("acaatggtccctattagtgggcggcggcccgtataaact", ["taa", "tag", "tga"]))

print(find_str("tcaaatatgcccggcggcgggtgattatccctggtaaca", "atg"))
print(end_codon("tcaaatatgcccggcggcgggtgattatccctggtaaca", ["taa", "tag", "tga"]))

txt = "acaatggtccctattagtgggcggcggcccgtataaact"
rvs = txt[::-1]

print(rvs[6:24])
print(txt[3:36])
