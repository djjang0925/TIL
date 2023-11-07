import requests
from bs4 import BeautifulSoup

keyword = input("검색어 입력: ")
response = requests.get("https://search.naver.com/search.naver?where=news&sm=tab_jum&query=" + keyword)
html = response.text

soup = BeautifulSoup(html, 'html.parser')
headlines = soup.select(".news_tit")

for headline in headlines:
    title = headline.text
    url = headline.attrs['href']

    print(title)
    print(url)
