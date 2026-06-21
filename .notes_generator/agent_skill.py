import os
# Assuming 'antigravity' or your specific LLM SDK is imported here
import llm_framework 

def generate_dsa_notes(topic_folder_path: str, output_path: str):
    """
    Agent skill to read topic templates and additional explanations, 
    then generate structured markdown notes.
    """
    
    template_path = os.path.join(topic_folder_path, 'input_template.md')
    theory_path = os.path.join(topic_folder_path, 'additional_explainations.md')
    
    # 1. Read the User Input
    try:
        with open(template_path, 'r') as f:
            user_input = f.read()
    except FileNotFoundError:
        return "Error: input_template.md not found in the specified folder."

    # 2. Read Additional Explanations (Optional)
    theory_content = ""
    if os.path.exists(theory_path):
        with open(theory_path, 'r') as f:
            theory_content = f.read()
            
    # 3. Construct the Payload
    prompt = f"""
    You have received a new generation request. 
    
    USER INPUT & QUESTIONS:
    {user_input}
    
    THEORETICAL EXPLANATIONS (Include at the top of the notes):
    {theory_content if theory_content else "None provided."}
    
    Generate the final markdown notes strictly following your system instructions.
    """
    
    # 4. Trigger the Agent (Replace with your framework's execution method)
    agent = llm_framework.Agent(system_prompt_file="system_prompt.md")
    response = agent.generate(prompt)
    
    # 5. Save the Output
    final_output_file = os.path.join(output_path, f"{os.path.basename(topic_folder_path)}_notes.md")
    with open(final_output_file, 'w') as f:
        f.write(response)
        
    return f"Success! Notes successfully generated and saved to {final_output_file}"

# Example execution:
# generate_dsa_notes('./repo/binary_search', './repo/binary_search')