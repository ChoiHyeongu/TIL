import chiren
import random
import urllib.request

def download_web_image(url):
    name = random.randrange(1, 1000)
    full_file_name = str(name) + ".jpg"
    urllib.request.urlretrieve(url, full_file_name)

download_web_image("http://dimg.donga.com/ugc/CDB/WEEKLY/Article/5a/bd/ea/9e/5abdea9e0ef5d2738de6.jpg")


