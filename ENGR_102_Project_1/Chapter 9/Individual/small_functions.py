# By submitting this assignment, I agree to the following:
#   "Aggies do not lie, cheat, or steal, or tolerate those who do."
#   "I have not given or received any unauthorized aid on this assignment."
#
# Name:         Kiet Nguyen
# Section:      509
# Assignment:   Lab 9
# Date:         10/30/22
#

def parta(r_sphere, r_hole):  # This is optional
    return


def partb(n):
    count = 0
    nums = []
    for i in range(n - 1, 0, -2):  # Establishes starting number
        if i % 2 == 0:  # If number is even start incrementing from odd number below
            i -= 1
        for j in range(i, 0, -2):  # Increment
            if count + j > n:
                break
            else:
                count += j
                nums.append(j)
        if count != n:
            count = 0
            nums = []
        else:
            nums.reverse()
            return nums
    return False


def partc(c, name, company, email):
    if len(company) >= len(email):  # Check for largest length
        length = 6 + len(company)
    else:
        length = 6 + len(email)
    if len(name) + 6 > length:
        length = 6 + len(name)

    name_spacing = (length - 2 - len(name)) // 2        # Adjust microspacing
    company_spacing = (length - 2 - len(company)) // 2
    email_spacing = (length - 2 - len(email)) // 2

    if 2 * name_spacing + len(name) + 2 < length:  #Adjust inner spacing
        name = name + ' '
    if 2 * company_spacing + len(company) + 2 < length:
        company = company + ' '
    if 2 * email_spacing + len(email) + 2 < length:
        email = email + ' '

    string1 = '' + c * length + '\n' + c + ' ' * name_spacing + name + ' ' * name_spacing + c
    string2 = '' + c + ' ' * company_spacing + company + ' ' * company_spacing + c
    string3 = '' + c + ' ' * email_spacing + email + ' ' * email_spacing + c + '\n' + c * length
    comp_string = string1 + '\n' + string2 + '\n' + string3

    return comp_string


def partd(nums):
    nums.sort()
    if len(nums) % 2 == 0:  # If list has two medians, take mean
        median = (nums[len(nums) // 2] + nums[(len(nums) // 2) - 1]) / 2
    else:
        median = nums[len(nums) // 2]
    return min(nums), median, max(nums)


def parte(times, distances):
    velocity = []
    i = 1
    while i < len(times):
        velocity.append(distances[i] - distances[i - 1])  # subtract previous distance
        i += 1

    return velocity


def partf(nums):
    for i in range(len(nums)):  # 1st number
        for j in range(i + 1, len(nums)):  # 2nd number
            if nums[i] + nums[j] == 2026:  # add numbers
                return nums[i] * nums[j]
    return False

