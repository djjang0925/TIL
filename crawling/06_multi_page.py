import requests
from bs4 import BeautifulSoup

keyword = input("검색어 입력: ")
last_page = int(input("몇 페이지까지 검색?: "))

current_page = 1
for page in range(1, last_page * 10, 10):
    print(f'==================={current_page}페이지====================')
    response = requests.get(f"https://search.naver.com/search.naver?where=news&sm=tab_jum&query={keyword}&start={page}")
    html = response.text

    soup = BeautifulSoup(html, 'html.parser')
    headlines = soup.select(".news_tit")

    for headline in headlines:
        title = headline.text
        url = headline.attrs['href']

        print(title)
        print(url)

    current_page += 1