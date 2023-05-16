# 废稿
import os

# 得到指定目录下所有的md文件，不包含子目录
def get_md_files(path):
    md_files = []
    for root, dirs, files in os.walk(path):
        for file in files:
            if file.endswith(".md"):
                md_files.append(os.path.join(root, file))
    return md_files


# 得到相应md文件图片文件夹下的所有资源，不包含子目录
def get_image_files(fn):  # fn: md文件名，相对路径为：image/md文件名不包含扩展名
    image_files = []
    image_path = os.path.join(os.path.dirname(fn), "image")
    if os.path.exists(image_path):
        for root, dirs, files in os.walk(image_path):
            for file in files:
                image_files.append(os.path.join(root, file))
    return image_files


# 逐行遍历md文件，找到图片资源
def get_image_lines(fn):
    with open(fn, "r", encoding="utf-8") as f:
        lines = f.readlines()
    img_dict = {}
    i = 0
    while i < len(lines):
        line = lines[i]
        if "![" in line or "<img" in line:
            img_list = []
            for word in line.split():
                if "://" in word:
                    if (
                        ".png" in word
                        or ".jpg" in word
                        or ".jpeg" in word
                        or ".gif" in word
                    ):
                        img_list.append(word)
            j = i + 1
            while j < len(lines):
                next_line = lines[j]
                if "![" in next_line or "<img" in next_line:
                    break
                for word in next_line.split():
                    if "://" in word:
                        if (
                            ".png" in word
                            or ".jpg" in word
                            or ".jpeg" in word
                            or ".gif" in word
                        ):
                            img_list.append(word)
                j += 1
            img_dict[i + 1] = img_list
            i = j
        else:
            i += 1
    return img_dict
