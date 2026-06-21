import time
import pandas as pd
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager

def scrape_full_dsa_sheet_selenium():
    print("Initializing Chrome browser options...")
    chrome_options = Options()
    # Keep headless=False to allow visual confirmation and minimize anti-bot triggers
    chrome_options.add_argument("--start-maximized")
    chrome_options.add_argument("--disable-blink-features=AutomationControlled")
    
    # Setup automated ChromeDriver binary management
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=chrome_options)
    
    url = "https://takeuforward.org/dsa/strivers-a2z-sheet-learn-dsa-a-to-z"
    print(f"Navigating to destination URL: {url}")
    
    try:
        driver.get(url)
        # Allow the modern single-page-app core assets to construct
        time.sleep(5) 
        
        print("Locating topic accordions to expand content data...")
        # Targets the structural elements responsible for toggling hidden sheets
        expand_buttons = driver.find_elements(By.CSS_SELECTOR, "div.cursor-pointer")
        
        for index, btn in enumerate(expand_buttons):
            try:
                # Scroll element smoothly into physical viewport area before clicking
                driver.execute_script("arguments[0].scrollIntoView({block: 'center'});", btn)
                time.sleep(0.2)
                btn.click()
                time.sleep(0.3)  # Interval for dynamic React layout expansion
            except Exception:
                # Ignore isolated structural components that are non-interactive
                continue
                
        print("Gathering expanded rows and parsing properties...")
        scraped_data = []
        
        # Locate all structural records embedded inside the table bodies
        rows = driver.find_elements(By.CSS_SELECTOR, "table tbody tr")
        
        for row in rows:
            try:
                cells = row.find_elements(By.TAG_NAME, "td")
                
                if len(cells) >= 5:
                    problem_name = cells[1].text.strip()
                    difficulty = cells[-1].text.strip()
                    
                    # Ensure it is a valid functional row containing clear structural elements
                    if not problem_name or difficulty not in ["Easy", "Medium", "Hard"]:
                        continue
                        
                    # Initialize target link mapping fields
                    youtube_link = None
                    article_link = None
                    leetcode_link = None
                    coding_ninjas_link = None
                    gfg_link = None
                    
                    # Extract all internal routing anchors inside current table row block
                    anchors = row.find_elements(By.TAG_NAME, "a")
                    for anchor in anchors:
                        href = anchor.get_attribute("href")
                        if not href:
                            continue
                            
                        # Classify the extracted hyperlinks based on destination domains
                        if "youtube.com" in href or "youtu.be" in href:
                            youtube_link = href
                        elif "takeuforward.org" in href:
                            article_link = href
                        elif "leetcode.com" in href:
                            leetcode_link = href
                        elif "codingninjas.com" in href or "codestudio" in href:
                            coding_ninjas_link = href
                        elif "geeksforgeeks.org" in href:
                            gfg_link = href
                            
                    scraped_data.append({
                        "Problem Name": problem_name,
                        "Difficulty": difficulty,
                        "YouTube Video": youtube_link,
                        "Article Link": article_link,
                        "LeetCode Link": leetcode_link,
                        "Coding Ninjas Link": coding_ninjas_link,
                        "GFG Link": gfg_link
                    })
            except Exception as row_err:
                # Silently catch dynamic node detachments if tables refresh state mid-loop
                continue
                
        # Persist extracted mapping matrix rows to disk using Pandas structure
        if scraped_data:
            df = pd.DataFrame(scraped_data)
            output_filename = "strivers_a2z_selenium_sheet.csv"
            df.to_csv(output_filename, index=False)
            print(f"Process complete! Saved {len(scraped_data)} records to '{output_filename}'.")
        else:
            print("Processing complete, but no rows matched targets. Check structural class elements.")
            
    finally:
        print("Tearing down Chrome instance...")
        driver.quit()

if __name__ == "__main__":
    scrape_full_dsa_sheet_selenium()