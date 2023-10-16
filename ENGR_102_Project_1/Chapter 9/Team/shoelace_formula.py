# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Names:        Michael Chrisanthus
#               Nathan Yandell
#               Brandon Le
#               Kiet Nguyen
# Section:      Section 509
# Assignment:   Lab 1
# Date:         24 October 2022

def getpoints(string):  # Convert string into set of lists
    mylist = string.split()
    for i in range(len(mylist)):
        mylist[i] = mylist[i].split(",")

    for i in range(len(mylist)):  # Convert into ints
        for j in range(2):
            mylist[i][j] = int(mylist[i][j])

    return mylist


def cross(list1, list2):  # Cross multiply a single set of points
    crossed = (list1[0] * list2[1]) - (list1[1] * list2[0])
    return crossed


def shoelace(mylist):  # Cross all points

    result = 0
    for i in range(len(mylist)-1):
        result += cross(mylist[i], mylist[i+1])

    result += cross(mylist[len(mylist)-1], mylist[0])
    return result / 2


def main():
    string = input("Please enter the vertices: ")
    points = getpoints(string)
    area = shoelace(points)
    print("The area of the polygon is" , area)


if __name__ == '__main__':
    main()
