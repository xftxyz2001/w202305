import os


def clean_empty_dir(path):
    for root, dirs, files in os.walk(path):
        for dir in dirs:
            dir_path = os.path.join(root, dir)
            if not os.listdir(dir_path):
                os.rmdir(dir_path)
                print("删除空文件夹：", dir_path)


if __name__ == "__main__":
    clean_empty_dir(".")
